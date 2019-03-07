package com.ccssoft.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class WebserviceApplication {

  @Autowired Send send;

  public static void main(String[] args) {
    SpringApplication.run(WebserviceApplication.class, args);
  }

  @GetMapping("/invoke")
  public String invoke() {
    String s = send.send2Pboss();
    return s;
  }

  @GetMapping("/invoke1")
  public String invoke1() {
    return send.sendByServiceClient();
  }

 
}
