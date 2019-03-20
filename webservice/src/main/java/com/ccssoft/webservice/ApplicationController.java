package com.ccssoft.webservice;

import com.ccssoft.webservice.config.BusinessConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * Date 2019/3/20 10:00<br>
 * Author Administrator<br>
 */
@RestController
@Slf4j
public class ApplicationController {
  
  @Autowired
  BusinessConfig businessConfig;
  
  @GetMapping("/business/config")
  public Object config() {
    log.info("businessConfig,{}", businessConfig);
    return businessConfig;
  }
}
