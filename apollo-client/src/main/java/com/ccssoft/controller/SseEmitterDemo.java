package com.ccssoft.controller;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author: Administrator
 * @date: 2019/8/30/21:50
 */
@RestController
@Slf4j
public class SseEmitterDemo {

  SseEmitter emitter = new SseEmitter();

  @GetMapping("/getEm")
  public SseEmitter getEmitter() {

    return emitter;
  }

  @GetMapping("/setEm")
  public String setEm() {
    try {
      emitter.send(System.currentTimeMillis());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "SUCCESS";
  }

  @GetMapping("/complete")
  public String completeEm() {
    emitter.complete();
    return "COMPLETE";
  }
}
