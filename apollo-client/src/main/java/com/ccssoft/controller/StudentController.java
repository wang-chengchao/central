package com.ccssoft.controller;

import com.ccssoft.configproperties.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date: 2019/8/23/15:07
 */
@RestController
@Slf4j
public class StudentController {

  @Autowired Student student;

  @Value("${person.name:default}")
  private String name;

  @GetMapping(path = "/student/info")
  public Student studentInfo() {
    log.info("person.name，{}", name);
    return student;
  }

  @GetMapping(path = "/person/name")
  public String personName() {
    log.info("person.name，{}", name);
    return name;
  }
}
