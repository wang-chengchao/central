package com.ccssoft;

import com.alibaba.fastjson.JSONObject;
import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * <br>
 * Date 2019/1/12 18:33<br>
 * Author Administrator<br>
 */
public class SsoAuthenticationToken extends AbstractAuthenticationToken {

  private final Object principal;
  
  private JSONObject thirdUserInfo;
  
  public SsoAuthenticationToken(String name, JSONObject thirdUserInfo) {
    super(null);
    this.principal = name;
    this.thirdUserInfo = thirdUserInfo;
    super.setAuthenticated(false);
  }
  
  public JSONObject getThirdUserInfo() {
    return thirdUserInfo;
  }

  public SsoAuthenticationToken(
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
  
  public void setThirdUserInfo(JSONObject thirdUserInfo) {
    this.thirdUserInfo = thirdUserInfo;
  }
  
  @Override
  public void eraseCredentials() {
    super.eraseCredentials();
  }
}
