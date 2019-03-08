package com.ccssoft.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@RefreshScope
public class WebserviceApplication {

  @Autowired Send send;
  
  @Value("${user.info.name}")
  private String name;
  
  @Value("${user.info.age}")
  private String age;

  public static void main(String[] args) {
    SpringApplication.run(WebserviceApplication.class, args);
  }

  @GetMapping("/invoke")
  public String invoke() {
    return send.send2Pboss();
  }
  
  @GetMapping("/name")
  public String getName() {
    
    return this.name;
  }
  
  @GetMapping("/age")
  public String getAge() {
    
    return this.age;
  }
}
