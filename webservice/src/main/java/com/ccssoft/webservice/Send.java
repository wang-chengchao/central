package com.ccssoft.webservice;

import static org.apache.commons.lang3.StringUtils.substringBetween;

import com.ccssoft.webservice.entity.DeviceBind;
import com.ccssoft.webservice.model.gen.HandleMessage;
import com.ccssoft.webservice.model.gen.ObjectFactory;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.support.MarshallingUtils;

/**
 * <br>
 * Date 2019/3/6 18:23<br>
 * Author Administrator<br>
 */
@Service
@Slf4j
public class Send extends WebServiceGatewaySupport {

  @Value("${smartflow.webservices.sg2pboss}")
  private String url;
  
  @Value("${smartflow.webservices.sg2bss1}")
  private String url1;

  public Send() {

    Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
    jaxb2Marshaller.setContextPaths(
        "com.ccssoft.webservice.model.gen", "com.ccssoft.webservice.entity");
    super.setMarshaller(jaxb2Marshaller);
    super.setUnmarshaller(jaxb2Marshaller);
    // this.setInterceptors(new ClientInterceptor[]{new Sg2BssClientInterceptor()});
  }

  String content =
      "<content> <recordInfo> <orderId>22019022709</orderId> <serialNo>22019022709</serialNo> <workflowid>CMCC-GZ-SGYWKT-20190227-28327882</workflowid> <productInstId>22019022709</productInstId> <businessType>GroupInstall</businessType> <specType>007</specType> <dealResult>0</dealResult> <dealDesc>处理成功</dealDesc> <description></description> <cityId>200</cityId> <fulfillDate>2019-02-28T15:21:08.180</fulfillDate> <productServiceLevel>4</productServiceLevel> <serviceLevel>4</serviceLevel> <paramInfo> <paramCode>productObject</paramCode> <paramValue> <paramInfo> <paramCode>ipType</paramCode> <paramValue>1</paramValue> <buildingName>南华路401号</buildingName> <buildingOid>513320</buildingOid> <customerRoomAddress>广州市番禺区桥南街南华路401号5栋/502</customerRoomAddress> </paramInfo> <paramInfo> <paramCode>ipInterRequiredCount</paramCode> <paramValue>1</paramValue> <buildingName>南华路401号</buildingName> <buildingOid>513320</buildingOid> <customerRoomAddress>广州市番禺区桥南街南华路401号5栋/502</customerRoomAddress> </paramInfo> <paramInfo> <paramCode>ipCustomerRequiredCount</paramCode> <paramValue></paramValue> <buildingName>南华路401号</buildingName> <buildingOid>513320</buildingOid> <customerRoomAddress>广州市番禺区桥南街南华路401号5栋/502</customerRoomAddress> </paramInfo> </paramValue> </paramInfo> </recordInfo> </content><attachRef/>";

  public String send2Pboss() {
    WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
    HandleMessage handleMessage = prepareInvoke();
    String o =
        webServiceTemplate.sendAndReceive(
            url,
            request -> {
              if (handleMessage != null) {
                Marshaller marshaller = getMarshaller();
                if (marshaller == null) {
                  throw new IllegalStateException(
                      "No marshaller registered. Check configuration of WebServiceTemplate.");
                }
                MarshallingUtils.marshal(marshaller, handleMessage, request);
              }
            },
            responseWebserviceMsg -> {
              Unmarshaller unmarshaller = getUnmarshaller();
              if (unmarshaller == null)
                throw new IllegalStateException(
                    "No unmarshaller registered. Check configuration of WebServiceTemplate.");
              ByteArrayOutputStream out = new ByteArrayOutputStream();
              responseWebserviceMsg.writeTo(out);
              return new String(out.toByteArray(), Charset.forName("UTF-8"));
            });
    String s = substringBetween(o, "<form>", "</form>");
    return o;
  }
  
  protected HandleMessage prepareInvoke() {
    HandleMessage h = new ObjectFactory().createHandleMessage();
    h.setCallerSystem("sg");
    h.setCallerPwd("pw");
    h.setInterfaceType("replyWorkFlow");
    h.setForm(content);
    return h;
  }
  
  public String axis(DeviceBind deviceBind) {
    
    WebServiceTemplate template = getWebServiceTemplate();
    return template.sendAndReceive(
        url1,
        requestCallBack -> {
          if (deviceBind != null) {
            Marshaller marshaller = getMarshaller();
            if (marshaller == null) {
              throw new IllegalStateException(
                  "No marshaller registered. Check configuration of WebServiceTemplate.");
            }
            MarshallingUtils.marshal(marshaller, deviceBind, requestCallBack);
          }
        },
        response -> {
          ByteArrayOutputStream os = new ByteArrayOutputStream();
          response.writeTo(os);
          return new String(os.toByteArray(), Charset.forName("UTF-8"));
        });
  }
}
