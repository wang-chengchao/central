package com.ccssoft.webservice.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <br>
 * Date 2019/3/8 21:17<br>
 * Author Administrator<br>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {
      "userID",
      "MAC",
      "forcedFlag",
      "detailParam",
    })
@XmlRootElement(name = "deviceBindReq")
public class DeviceBindReq {

  @XmlElement protected String userID;

  @XmlElement protected String MAC;

  @XmlElement protected int forcedFlag;

  @XmlElement protected String detailParam;

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getMAC() {
    return MAC;
  }

  public void setMAC(String MAC) {
    this.MAC = MAC;
  }

  public int getForcedFlag() {
    return forcedFlag;
  }

  public void setForcedFlag(int forcedFlag) {
    this.forcedFlag = forcedFlag;
  }

  public String getDetailParam() {
    return detailParam;
  }

  public void setDetailParam(String detailParam) {
    this.detailParam = detailParam;
  }
}
