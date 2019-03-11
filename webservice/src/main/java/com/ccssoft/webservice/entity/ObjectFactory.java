package com.ccssoft.webservice.entity;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * <br>
 * Date 2019/3/9 20:28<br>
 * Author Administrator<br>
 */
@XmlRegistry
public class ObjectFactory {
  
  public ObjectFactory(){
  
  }
  
  public DeviceBindReq createDeviceBindReq(){
    return new DeviceBindReq();
  }
  
  public DeviceBind createDeviceBind(){
    return new DeviceBind();
  }
  
}