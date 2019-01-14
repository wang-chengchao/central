package com.ccssoft;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * <br>
 * Date 2019/1/12 17:25<br>
 * Author Administrator<br>
 */
public class SSoAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  public SSoAuthenticationFilter() {
    super(new AntPathRequestMatcher("/oauth/token", "GET"));
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    SsoAuthenticationToken token = new SsoAuthenticationToken("admin");
    setDetails(request, token);

    return getAuthenticationManager().authenticate(token);
  }

  protected void setDetails(HttpServletRequest request, SsoAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }
  
  protected String obtainUsername(HttpServletRequest request) {
    
    return request.getParameter("username");
  }
  
  protected String obtainPassword(HttpServletRequest request) {
    
    return request.getParameter("password");
  }
}
