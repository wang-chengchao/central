package com.ccssoft.webservice.model.sg2pboss;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * <br>
 * Date 2019/4/8 10:34<br>
 * Author Administrator<br>
 */
@XmlRegistry
public class ObjectFactory {
  
  public ObjectFactory() {
  
  }
  
  public ReverseService createReverseService() {
    
    return new ReverseService();
  }
  
}