package com.ccssoft.webservice.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * <br>
 * Date 2019/3/20 9:51<br>
 * Author Administrator<br>
 */
@ConfigurationProperties(prefix = "config")
@RefreshScope
public class BusinessConfig {
  
  private Map<String, Object> rollback = new HashMap<>();
  
  private Map<String, String> other = new HashMap<>();
  
  public Map<String, Object> getRollback() {
    return rollback;
  }
  
  public void setRollback(Map<String, Object> rollback) {
    this.rollback = rollback;
  }
  
  public Map<String, String> getOther() {
    return other;
  }
  
  public void setOther(Map<String, String> other) {
    this.other = other;
  }
}
