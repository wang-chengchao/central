package com.ccssoft.webservice.model.sg2pboss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <br>
 * Date 2019/4/8 10:29<br>
 * Author Administrator<br>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "head",
    propOrder = {"callerSystem", "serSupplier", "callerPwd", "bipCode", "callTime", "sequenceNo"})
public class Head {
  
  @XmlElement
  protected String callerSystem;
  
  @XmlElement
  protected String serSupplier;
  
  @XmlElement
  protected String callerPwd;
  
  @XmlElement
  protected String bipCode;
  
  @XmlElement
  protected String callTime;
  
  @XmlElement
  protected String sequenceNo;
  
  public String getCallerSystem() {
    return callerSystem;
  }
  
  public void setCallerSystem(String callerSystem) {
    this.callerSystem = callerSystem;
  }
  
  public String getSerSupplier() {
    return serSupplier;
  }
  
  public void setSerSupplier(String serSupplier) {
    this.serSupplier = serSupplier;
  }
  
  public String getCallerPwd() {
    return callerPwd;
  }
  
  public void setCallerPwd(String callerPwd) {
    this.callerPwd = callerPwd;
  }
  
  public String getBipCode() {
    return bipCode;
  }
  
  public void setBipCode(String bipCode) {
    this.bipCode = bipCode;
  }
  
  public String getCallTime() {
    return callTime;
  }
  
  public void setCallTime(String callTime) {
    this.callTime = callTime;
  }
  
  public String getSequenceNo() {
    return sequenceNo;
  }
  
  public void setSequenceNo(String sequenceNo) {
    this.sequenceNo = sequenceNo;
  }
}