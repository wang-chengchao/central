package com.ccssoft.webservice.config;

import com.sun.xml.messaging.saaj.soap.impl.ElementImpl;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.w3c.dom.Node;

/**
 * <br>
 * Date 2019/3/11 10:42<br>
 * Author Administrator<br>
 */
public class Sg2BssClientInterceptor implements ClientInterceptor {

  private static final String NAMESPACE = "http://service.unifBoss.iptvbss.newyulong.com";
  private static final String PREFIX = "ser";

  private static final String ENCODING_STYLE = "http://schemas.xmlsoap.org/soap/encoding/";

  @Override
  public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
    SaajSoapMessage msg = (SaajSoapMessage) messageContext.getRequest();
    SOAPMessage saajMessage = msg.getSaajMessage();
    try {
      alterSoap(saajMessage);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return true;
  }

  @Override
  public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
    return true;
  }

  @Override
  public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
    return true;
  }

  @Override
  public void afterCompletion(MessageContext messageContext, Exception ex)
      throws WebServiceClientException {}

  private void alterSoap(SOAPMessage soapMessage) throws Exception {
    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(PREFIX, NAMESPACE);
    SOAPBody soapBody = soapMessage.getSOAPBody();
    Node firstChild = soapBody.getFirstChild();
    ElementImpl element = (ElementImpl) firstChild;
    element.setEncodingStyle(ENCODING_STYLE);
  }
}
