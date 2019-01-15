package com.ccssoft;

import com.alibaba.fastjson.JSON;
import com.ccssoft.annotation.EnableSso;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/to")
public class Application {

  static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @RequestMapping(value = "/login")
  public String login(HttpServletRequest request) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.err.println("username:" + username + "password:" + password);
    if ("kermit".equals(username) && "kermit".equals(password)) {
      request.setAttribute("user", username);
      return "info";
    }
    return null;
  }

  @GetMapping("/user")
  @ResponseBody
  public Object getCurrentUser1(Authentication authentication, HttpServletRequest request)
      throws UnsupportedEncodingException {
    log.info(
        "【SecurityOauth2Application】 getCurrentUser1 authenticaiton={}",
        JSON.toJSONString(authentication));
    /*
    String header = request.getHeader("Authorization");
    String token = StringUtils.substringAfter(header, "bearer ");

    Claims claims = Jwts.parser().setSigningKey(oAuth2Properties.getJwtSigningKey().getBytes("UTF-8")).parseClaimsJws(token).getBody();
    String blog = (String) claims.get("blog");
    log.info("【SecurityOauth2Application】 getCurrentUser1 blog={}", blog);*/

    return authentication;
  }
}


