package com.ccssoft.controller;

import com.ccssoft.configproperties.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping(path = "/student/info")
  public Student studentInfo() {
    log.info("studentInfo");
    return student;
  }
}
