package com.ccssoft;

import com.ccssoft.configproperties.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date: 2019/8/23/14:44
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {Student.class})
@RestController
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
  
  
}
