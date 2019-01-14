package com.ccssoft;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <br>
 * Date 2019/1/12 18:39<br>
 * Author Administrator<br>
 */
public class SSoAuthenticationProvider implements AuthenticationProvider {

  private SsoUserDetailsService customerUserDetailsService;

  public SSoAuthenticationProvider(SsoUserDetailsService customerUserDetailsService) {
    this.customerUserDetailsService = customerUserDetailsService;
  }

  public SsoUserDetailsService getCustomerUserDetailsService() {
    return customerUserDetailsService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    SsoAuthenticationToken token = (SsoAuthenticationToken) authentication;
  
    UserDetails userDetails =
        customerUserDetailsService.loadUserByUsername((String) token.getPrincipal());
    if (userDetails == null) throw new InternalAuthenticationServiceException("认证失败");

    SsoAuthenticationToken auth =
        new SsoAuthenticationToken(userDetails, userDetails.getAuthorities());
    auth.setDetails(token.getDetails());
    return auth;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return SsoAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
