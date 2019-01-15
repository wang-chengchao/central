package com.ccssoft;

import java.util.HashMap;
import java.util.Map;
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

/**
 * <br>
 * Date 2019/1/12 17:25<br>
 * Author Administrator<br>
 */
public class SsoAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(SsoAuthenticationFilter.class);
  
  private static final String ACCESS_TOKEN_CHECKURL =
      "http://188.0.96.27:30021/sso/oauth/check_token";

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
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("token", accessToken);
    // String result = HttpClientUtils.doGet(ACCESS_TOKEN_CHECKURL, parameters);
    // TODO 调用restful验证token有效性
    //LOGGER.info("返回用户信息=>{}", result);
  
    String username = "admin";
    SsoAuthenticationToken token = new SsoAuthenticationToken(username != null ? username : "");
    setDetails(request, token);

    return getAuthenticationManager().authenticate(token);
  }

  protected void setDetails(HttpServletRequest request, SsoAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }
  
  protected String obtainAccessToken(HttpServletRequest request) {
    
    return request.getParameter("access_token");
  }
  
  @Deprecated
  protected String obtainPassword(HttpServletRequest request) {
    
    return request.getParameter("password");
  }
}
