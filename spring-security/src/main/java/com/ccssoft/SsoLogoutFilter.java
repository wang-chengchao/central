package com.ccssoft;

import java.io.IOException;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.GenericFilterBean;

/**
 * <br>
 * Date 2019/1/15 15:15<br>
 * Author Administrator<br>
 */
public class SsoLogoutFilter extends GenericFilterBean {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(SsoLogoutFilter.class);
  
  RestTemplate restTemplate = new RestTemplate();
  
  private RequestMatcher logoutMatcher;
  
  private final LogoutHandler handler;
  
  private final LogoutSuccessHandler logoutSuccessHandler;
  
  private static final String LOGOUT_LOGGER_URL = "";
  
  public SsoLogoutFilter() {
    this.logoutMatcher = new AntPathRequestMatcher("/logout");
    SimpleUrlLogoutSuccessHandler simpleUrlLogoutSuccessHandler =
        new SimpleUrlLogoutSuccessHandler();
    simpleUrlLogoutSuccessHandler.setDefaultTargetUrl("/login");
    this.handler = new SecurityContextLogoutHandler();
    this.logoutSuccessHandler = simpleUrlLogoutSuccessHandler;
  }
  
  public SsoLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler... handlers) {
    this.handler = new CompositeLogoutHandler(handlers);
    Assert.notNull(logoutSuccessHandler, "logoutSuccessHandler cannot be null");
    this.logoutSuccessHandler = logoutSuccessHandler;
  }
  
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (requiresLogout(request, authentication)) {
      try {
        String log =
            restTemplate.getForObject(LOGOUT_LOGGER_URL, String.class, Collections.emptyMap());
        LOGGER.info("第三方登出日志=>{}", log);
      } catch (Exception e) {
        LOGGER.info("第三方返回登出日志错误=>{}", e.getMessage());
      }
      this.handler.logout(request, response, authentication);
      this.logoutSuccessHandler.onLogoutSuccess(request, response, authentication);
      return;
    }
    chain.doFilter(req, res);
  }
  
  protected boolean requiresLogout(HttpServletRequest request, Authentication authentication) {
    
    return this.logoutMatcher.matches(request) && authentication instanceof SsoAuthenticationToken;
  }
  
  public void setLogoutRequestMatcher(RequestMatcher logoutMatcher) {
    this.logoutMatcher = logoutMatcher;
  }
}
