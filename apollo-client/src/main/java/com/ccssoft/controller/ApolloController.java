package com.ccssoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date: 2019/8/27/11:00
 */
@RestController
public class ApolloController {

  @Value("${keyFromApollo:keyFromApollo}")
  private String val;

  @GetMapping("/apollo/key")
  public String getApolloKey() {
    return val;
  }
}
