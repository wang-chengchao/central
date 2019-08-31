package com.ccssoft.async;

import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author: Administrator
 * @date: 2019/8/31/10:11
 */
@RestController
@Slf4j
public class AsyncDeferredController {

  private final TaskServiceImpl taskService;

  @Autowired
  public AsyncDeferredController(TaskServiceImpl taskService) {
    this.taskService = taskService;
  }

  @GetMapping(path = "/deferred")
  public DeferredResult<String> executeSlowTask() {
    log.info("Request received");
    DeferredResult<String> deferredResult = new DeferredResult<>();
    CompletableFuture.supplyAsync(taskService::execute)
        .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
    log.info("Servlet thread released");

    return deferredResult;
  }
}
