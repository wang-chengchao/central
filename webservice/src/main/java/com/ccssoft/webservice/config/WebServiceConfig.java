package com.ccssoft.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

/**
 * <br>
 * Date 2019/3/11 10:37<br>
 * Author Administrator<br>
 */
@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {}
