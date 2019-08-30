package com.ccssoft;

import com.ccssoft.configproperties.SampleRedisConfig;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date: 2019/8/23/14:44
 */
@SpringBootApplication
@RestController
@Slf4j
@EnableAsync
public class Application {

  @Inject SampleRedisConfig sampleRedisConfig;

  @Inject Environment environment;

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  /*  @PostConstruct
  public void getConfFromApollo() {

    Config defaultConf = ConfigService.getAppConfig();
    Config devConf = ConfigService.getConfig("application-dev.yaml");
    devConf.addChangeListener(
        (event) -> {
          log.info("Changes for namespace,{} ", event.getNamespace());
          for (String key : event.changedKeys()) {
            ConfigChange change = event.getChange(key);
            System.out.println(
                String.format(
                    "Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s",
                    change.getPropertyName(),
                    change.getOldValue(),
                    change.getNewValue(),
                    change.getChangeType()));
          }
        });
  }*/

  @GetMapping("/redis/conf")
  public SampleRedisConfig sampleRedisConfig() {
    return sampleRedisConfig;
  }

  @GetMapping("/env/pro")
  public String getEnvProperties() {
    String aDefault = environment.getProperty("logging.config", "default");
    String aDefault1 = environment.getProperty("logging.level", "default");

    return aDefault + "  " + aDefault1;
  }
}
