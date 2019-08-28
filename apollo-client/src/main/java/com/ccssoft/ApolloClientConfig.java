package com.ccssoft;

import com.ccssoft.configproperties.Student;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Administrator
 * @date: 2019/8/23/14:43
 */
@EnableApolloConfig
@Configuration
@Slf4j
public class ApolloClientConfig {

  public ApolloClientConfig() {
    log.info("ApolloClientConfig Initial");
  }

  @Bean
  public Student student() {
    return new Student();
  }
}
