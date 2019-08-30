package com.ccssoft.controller;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author: Administrator
 * @date: 2019/8/30/21:24
 */
@RestController
@Slf4j
public class DeferredResultController {

  @Inject ProcessService service;

  @GetMapping("/getRes")
  public DeferredResult<String> getRes() {
    DeferredResult<String> deferredResult = new DeferredResult<>();
    log.info("start Process");
    service.process(deferredResult);
    log.info("after");
    return deferredResult;
  }

  @Component
  static class ProcessService {

    @Async
    public void process(DeferredResult<String> deferredResult) {

      try {
        TimeUnit.SECONDS.sleep(5);
        deferredResult.setResult("OK,ProcessSuccess," + LocalDateTime.now().toString());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
