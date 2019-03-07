package com.ccssoft.webservice.model.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <br>
 * Date 2019/3/7 14:40<br>
 * Author Administrator<br>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"returnInfo"})
@XmlRootElement(name = "content")
public class Content {

  @XmlElement(required = true)
  protected ReturnInfo returnInfo;

  public ReturnInfo getReturnInfo() {
    return returnInfo;
  }

  public void setReturnInfo(ReturnInfo returnInfo) {
    this.returnInfo = returnInfo;
  }
}
