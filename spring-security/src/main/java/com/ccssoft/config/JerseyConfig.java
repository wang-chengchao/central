package com.ccssoft.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.SpringComponentProvider;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * Date 2019/3/4 11:44<br>
 * Author Administrator<br>
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
  
  public JerseyConfig() {
    register(RequestContextFilter.class);
    packages("com.ccssoft");
    register(JacksonFeature.class);
    register(RequestContextFilter.class);
    register(SpringComponentProvider.class);
  }
}
