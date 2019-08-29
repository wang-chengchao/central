package com.ccssoft.configproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Administrator
 * @date: 2019/8/29/15:13
 */
@ConfigurationProperties(prefix = "redis.cache")
@Data
public class SampleRedisConfig {

  private int expireSeconds;
  private int commandTimeout;
}
