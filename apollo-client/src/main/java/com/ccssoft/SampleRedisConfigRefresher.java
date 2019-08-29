package com.ccssoft;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleRedisConfigRefresher implements ApplicationContextAware {

  ApplicationContext applicationContext;

  @ApolloConfigChangeListener(
      value = ConfigConsts.NAMESPACE_APPLICATION,
      interestedKeyPrefixes = {"redis.cache."})
  public void onChange(ConfigChangeEvent event) {
    log.info("changed redis.cache");
    refreshRedisConf(event);
  }

  public void refreshRedisConf(ConfigChangeEvent event) {

    applicationContext.publishEvent(new EnvironmentChangeEvent(event.changedKeys()));
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
