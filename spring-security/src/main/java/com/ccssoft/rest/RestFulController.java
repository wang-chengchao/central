package com.ccssoft.rest;

import com.ccssoft.config.JerseyConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <br>
 * Date 2019/3/4 11:27<br>
 * Author Administrator<br>
 */
@Slf4j
@Path(value = "/res")
public class RestFulController {
  
  @Autowired
  JerseyConfig jerseyConfig;
  
  @GET
  @Path("/hello")
  public String hello() {
    log.info("enter hello rest,{}", jerseyConfig);
    return "HELLO JERSEY";
  }
}
