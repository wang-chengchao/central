package com.ccssoft.webservice.model.sg2pboss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <br>
 * Date 2019/4/8 10:28<br>
 * Author Administrator<br>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"head", "content"})
@XmlRootElement(name = "reverseService", namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService")
public class ReverseService {
  
  @XmlElement(required = true)
  protected Head head;
  
  @XmlElement(required = true)
  protected String content;
  
  public Head getHead() {
    return head;
  }
  
  public void setHead(Head head) {
    this.head = head;
  }
  
  public String getContent() {
    return content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
}