package com.ccssoft.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator
 * @date: 2019/8/31/10:11
 */
@Service
@Slf4j
public class TaskServiceImpl {

  public String execute() {
    try {
      log.info("{},start execute", Thread.currentThread());
      Thread.sleep(5000);
      log.info("{},finish execute", Thread.currentThread());
      return "Task finished";
    } catch (InterruptedException e) {
      throw new RuntimeException();
    }
  }
}
