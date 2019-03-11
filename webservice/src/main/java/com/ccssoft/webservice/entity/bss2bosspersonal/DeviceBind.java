package com.ccssoft.webservice.entity.bss2bosspersonal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <br>
 * Date 2019/3/11 12:55<br>
 * Author Administrator<br>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"deviceBindReq", "sequenceID"})
@XmlRootElement(name = "deviceBind", namespace = "http://bean.unifBoss.iptvbss.newyulong.com")
public class DeviceBind {
  
  @XmlElement(name = "deviceBindReq")
  protected DeviceBindRequest deviceBindReq;
  
  @XmlElement
  protected java.lang.String sequenceID;
  
  public DeviceBindRequest getDeviceBindReq() {
    return deviceBindReq;
  }
  
  public void setDeviceBindReq(DeviceBindRequest deviceBindReq) {
    this.deviceBindReq = deviceBindReq;
  }
  
  public java.lang.String getSequenceID() {
    return sequenceID;
  }
  
  public void setSequenceID(java.lang.String sequenceID) {
    this.sequenceID = sequenceID;
  }
}
