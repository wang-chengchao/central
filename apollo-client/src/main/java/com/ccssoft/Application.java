package com.ccssoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date: 2019/8/23/14:44
 */
@SpringBootApplication
@RestController
public class Application {
  
  

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
