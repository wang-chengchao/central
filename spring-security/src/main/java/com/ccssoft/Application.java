package com.ccssoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: <br>
 * @Author: Administrator<br>
 * @CreateDate: 2018/10/11 14:05<br>
 * @UpdateDate: 2018/10/11 14:05<br>
 * @Version: 1.0
 */
@SpringBootApplication
@Controller
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @RequestMapping(value = "/login")
  public String login() {
    return "login";
  }

  @GetMapping("/user")
  @ResponseBody
  public Authentication currentUser(Authentication authentication) {
    return authentication;
  }
  
  @GetMapping("/info")
  @ResponseBody
  public Authentication userInfo() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
