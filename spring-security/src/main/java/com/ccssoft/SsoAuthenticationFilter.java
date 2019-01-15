package com.ccssoft;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * <br>
 * Date 2019/1/12 17:25<br>
 * Author Administrator<br>
 */
public class SsoAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(SsoAuthenticationFilter.class);

  private RestTemplate restTemplate = new RestTemplate();

  private static final String ACCESS_TOKEN_CHECKURL =
      "";
  
  private static final String LOGIN_LOGGER_URL = "";

  public SsoAuthenticationFilter() {
    super(new AntPathRequestMatcher("/oauth/token", "GET"));
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    String accessToken = obtainAccessToken(request);
    if (!StringUtils.hasText(accessToken)) {
      throw new InternalAuthenticationServiceException("认证失败,access_token为空");
    }
    LOGGER.info("access-token=>{}", accessToken);
    String result;
    try {
      result = verifyAccessToken(accessToken);
      //  调用restful验证token有效性
      LOGGER.info("返回用户信息=>{}", result);
    } catch (Exception e) {
      throw new InternalAuthenticationServiceException(e.getMessage());
    }

    JSONObject thirdUserInfo = JSON.parseObject(result);
    thirdUserInfo.put("accessToken", accessToken);

    String username = obtainUsername(thirdUserInfo);
    if (username == null || "".equals(username)) {
      throw new InternalAuthenticationServiceException("access_token验证结果返回的user为空");
    }

    SsoAuthenticationToken token = new SsoAuthenticationToken(username, thirdUserInfo);
    setDetails(request, token);
    Authentication authenticated = getAuthenticationManager().authenticate(token);

    try {
      String log = doGetLoginLog(accessToken);
      LOGGER.info("Sso返回登录日志=>{}", log);
    } catch (Exception e) {
      LOGGER.info("Sso返回登录日志错误,{}", e.getMessage());
    }
    return authenticated;
  }

  protected void setDetails(HttpServletRequest request, SsoAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }
  
  protected String obtainAccessToken(HttpServletRequest request) {
    
    return request.getParameter("access_token");
  }
  
  protected String obtainUsername(JSONObject jsonObject) {
    
    return jsonObject.getString("user_name");
  }
  
  private String verifyAccessToken(String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<?> entity = new HttpEntity<>(headers);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ACCESS_TOKEN_CHECKURL);
    builder.queryParam("token", token);
    return restTemplate
        .exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class)
        .getBody();
  }
  
  private String doGetLoginLog(String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Connection", "close");
    headers.set("Authorization", "bearer " + token);
    HttpEntity<?> entity = new HttpEntity<>(headers);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(LOGIN_LOGGER_URL);
    return restTemplate
        .exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class)
        .getBody();
  }
}
