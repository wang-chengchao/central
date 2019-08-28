package com.ccssoft.configproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Administrator
 * @date: 2019/8/23/14:47
 */
@Data
@ConfigurationProperties(prefix = Student.DEFAULT_PREFIX)
public class Student {
  

  public static final String DEFAULT_PREFIX = "student";
  private int sno;

  private Teacher teacher ;
}
