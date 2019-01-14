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
public class CustomerAuthenticationProvider implements AuthenticationProvider {

  private CustomerUserDetailsService customerUserDetailsService;

  public CustomerAuthenticationProvider(CustomerUserDetailsService customerUserDetailsService) {
    this.customerUserDetailsService = customerUserDetailsService;
  }

  public CustomerUserDetailsService getCustomerUserDetailsService() {
    return customerUserDetailsService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    CustomerAuthenticationToken token = (CustomerAuthenticationToken) authentication;

    UserDetails userDetails =
        customerUserDetailsService.loadUserByUsername((String) token.getPrincipal());
    if (userDetails == null) throw new InternalAuthenticationServiceException("认证失败");

    CustomerAuthenticationToken auth =
        new CustomerAuthenticationToken(userDetails, userDetails.getAuthorities());
    auth.setDetails(token.getDetails());
    return auth;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return CustomerAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
