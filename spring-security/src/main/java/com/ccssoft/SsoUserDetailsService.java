package com.ccssoft;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * <br>
 * Date 2019/1/12 18:42<br>
 * Author Administrator<br>
 */
@Component
public class SsoUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (!"admin".equals(username)) {
      throw new UsernameNotFoundException("username not found");
    }
    return new User(
        username, "pwd", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
  }
}
