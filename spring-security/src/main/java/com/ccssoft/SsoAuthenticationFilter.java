package com.ccssoft;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

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
      result =
          restTemplate.getForObject(
              ACCESS_TOKEN_CHECKURL + "?token=" + accessToken,
              String.class,
              Collections.emptyMap());
      //  调用restful验证token有效性
      LOGGER.info("返回用户信息=>{}", result);
    } catch (Exception e) {
      throw new InternalAuthenticationServiceException(e.getMessage());
    }
  
    JSONObject thirdUserInfo = JSON.parseObject(result);
    String username = obtainUsername(thirdUserInfo);
    if (username == null || "".equals(username)) {
      throw new InternalAuthenticationServiceException("access_token验证结果返回的user为空");
    }
  
    SsoAuthenticationToken token = new SsoAuthenticationToken(username, thirdUserInfo);
    setDetails(request, token);
    Authentication authenticated = getAuthenticationManager().authenticate(token);
  
    try {
      String log =
          restTemplate.getForObject(
              LOGIN_LOGGER_URL + "?token=" + accessToken, String.class, Collections.emptyMap());
      LOGGER.info("Sso返回登录日志=>{}", log);
    } catch (Exception e) {
      LOGGER.info("第三方返回登录日志错误,{}", e.getMessage());
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
}
