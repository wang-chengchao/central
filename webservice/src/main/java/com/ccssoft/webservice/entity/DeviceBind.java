package com.ccssoft.webservice.entity;

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
@XmlRootElement(name = "deviceBind")
public class DeviceBind {

  @XmlElement protected DeviceBindReq deviceBindReq;

  @XmlElement protected String sequenceID;

  public DeviceBindReq getDeviceBindReq() {
    return deviceBindReq;
  }

  public void setDeviceBindReq(DeviceBindReq deviceBindReq) {
    this.deviceBindReq = deviceBindReq;
  }

  public String getSequenceID() {
    return sequenceID;
  }

  public void setSequenceID(String sequenceID) {
    this.sequenceID = sequenceID;
  }
}
