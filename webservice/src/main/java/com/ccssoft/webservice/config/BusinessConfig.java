package com.ccssoft.webservice.config;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * <br>
 * Date 2019/3/20 9:51<br>
 * Author Administrator<br>
 */
@ConfigurationProperties(prefix = BusinessConfig.PREFIX)
@RefreshScope
@Data
public class BusinessConfig {
  
  public static final String PREFIX = "config";
  
  private Map<String, Object> rollback = new HashMap<>();
  
  private Map<String, String> other = new HashMap<>();
  
}
