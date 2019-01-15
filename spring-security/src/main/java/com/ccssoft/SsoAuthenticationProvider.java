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
public class SsoAuthenticationProvider implements AuthenticationProvider {

  private SsoUserDetailsService customerUserDetailsService;

  public SsoAuthenticationProvider(SsoUserDetailsService customerUserDetailsService) {
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
    if (userDetails == null) {
      throw new InternalAuthenticationServiceException("第三方用户认证失败");
    }

    SsoAuthenticationToken auth =
        new SsoAuthenticationToken(userDetails, userDetails.getAuthorities());
    auth.setThirdUserInfo(token.getThirdUserInfo());
    auth.setDetails(token.getDetails());
  
    return auth;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return SsoAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
