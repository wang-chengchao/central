package com.ccssoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
@Order(1)
@Configuration
public class CustomerAuthenticationConfig
    extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

  @Autowired private CustomerUserDetailsService customerUserDetailsService;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    CustomerAuthenticationFilter filter = new CustomerAuthenticationFilter();
    filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler());
    filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler());

    CustomerAuthenticationProvider provider =
        new CustomerAuthenticationProvider(customerUserDetailsService);

    http.authenticationProvider(provider)
        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
  }
}
