package com.ccssoft;

import com.ccssoft.configproperties.SampleRedisConfig;
import com.ccssoft.configproperties.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Administrator
 * @date: 2019/8/23/14:43
 */
// @EnableApolloConfig(value = {"application", "application-dev.yaml"})
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

  @Bean
  public SampleRedisConfig sampleRedisConfig() {
    return new SampleRedisConfig();
  }
}
