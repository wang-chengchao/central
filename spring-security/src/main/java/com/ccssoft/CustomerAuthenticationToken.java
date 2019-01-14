package com.ccssoft;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * <br>
 * Date 2019/1/12 18:33<br>
 * Author Administrator<br>
 */
public class CustomerAuthenticationToken extends AbstractAuthenticationToken {

  private final Object principal;

  public CustomerAuthenticationToken(String name) {
    super(null);
    this.principal = name;
    super.setAuthenticated(false);
  }

  public CustomerAuthenticationToken(
      Object principal, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    super.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return this.principal;
  }

  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    if (isAuthenticated)
      throw new IllegalArgumentException(
          "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
    super.setAuthenticated(false);
  }

  @Override
  public void eraseCredentials() {
    super.eraseCredentials();
  }
}
