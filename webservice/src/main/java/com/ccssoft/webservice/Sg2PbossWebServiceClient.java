package com.ccssoft.webservice;

import com.ccssoft.webservice.model.sg2pboss.Head;
import com.ccssoft.webservice.model.sg2pboss.ObjectFactory;
import com.ccssoft.webservice.model.sg2pboss.ReverseService;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.support.MarshallingUtils;

/**
 * <br>
 * Date 2019/4/8 10:36<br>
 * Author Administrator<br>
 */
@Service
@Slf4j
public class Sg2PbossWebServiceClient extends WebServiceGatewaySupport {
  
  public Sg2PbossWebServiceClient() {
    Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
    jaxb2Marshaller.setContextPaths(
        "com.ccssoft.webservice.model.sg2pboss");
    super.setMarshaller(jaxb2Marshaller);
    super.setUnmarshaller(jaxb2Marshaller);
  }
  
  public String sendRequest() {
    
    WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
    
    ReverseService reverseService = new ObjectFactory().createReverseService();
    Head head = new Head();
    head.setCallerSystem("sg");
    head.setCallerPwd("123");
    head.setCallTime(LocalDateTime.now().toString());
    head.setBipCode("bitCode");
    head.setSequenceNo(UUID.randomUUID().toString());
    head.setSerSupplier("pboss");
    reverseService.setContent("<content></content>");
    reverseService.setHead(head);
    webServiceTemplate.sendAndReceive("http://localhost:8080/", request -> {
      if (reverseService != null) {
        Marshaller marshaller = getMarshaller();
        if (marshaller == null) {
          throw new IllegalStateException(
              "No marshaller registered. Check configuration of WebServiceTemplate.");
        }
        MarshallingUtils.marshal(marshaller, reverseService, request);
      }
    }, response -> {
    
    });
    return "OK";
  }
  
}