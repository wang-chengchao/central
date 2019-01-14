package com.ccssoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.PriorityOrdered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <br>
 * Date 2019/1/12 18:46<br>
 * Author Administrator<br>
 */
public class SsoAuthenticationConfig
    extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>
    implements PriorityOrdered {
  
  @Autowired
  private SsoUserDetailsService customerUserDetailsService;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    SsoAuthenticationFilter filter = new SsoAuthenticationFilter();
    filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler());
    filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler());
  
    SsoAuthenticationProvider provider = new SsoAuthenticationProvider(customerUserDetailsService);

    http.authenticationProvider(provider)
        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
  }
  
  @Override
  public int getOrder() {
    return 1;
  }
}
