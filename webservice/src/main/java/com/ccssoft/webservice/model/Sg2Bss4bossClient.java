/*
package com.ccssoft.webservice.model;

import com.alibaba.fastjson.JSON;
import java.rmi.RemoteException;
import java.util.UUID;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

*/
/**
 * <br>
 * Date 19-2-20 下午4:31<br>
 * Author zcb<br>
 *//*

@org.springframework.stereotype.Service
public class Sg2Bss4bossClient extends WebServiceGatewaySupport {
  @Value("${smartflow.webservices.sg2bss1}")
  private String url1;

  @Value("${smartflow.webservices.sg2bss2}")
  private String url2;

  */
/**
   * mac地址绑定
   *
   * @param deviceBindReq
   * @param regionName
   * @return
   * @throws ServiceException
   * @throws RemoteException
   *//*

  public String callDeviceBind(DeviceBindReq deviceBindReq, String regionName)
      throws ServiceException, RemoteException {
    // webService地址
    // webService地址使用华为的：广州,佛山,珠海,中山,江门,湛江,茂名,韶关,阳江,肇庆,清远,云浮

    // webService地址使用中兴的：深圳,东莞,汕头,惠州,揭阳,河源,梅州,汕尾,潮州

    // String endPoint="http://10.252.231.131:35000/BSS/services/BSS4BOSSServer";
    String endPoint = url1;
    if ("深圳,东莞,汕头,惠州,揭阳,河源,梅州,汕尾,潮州".contains(regionName)) {
      // endPoint="http://10.252.231.198:9346/BSS/services/BSS4BOSSServer";
      endPoint = url2;
    }
    // DeviceBindReq parseObject = JSON.parseObject(deviceBindReq,
    // DeviceBindReq.class);
    Service service = new Service();
    Call call;
    call = (Call) service.createCall();
    // QName由名称空间跟本地名称组成，看deploy.wsdd文件可知 <beanMapping qname="myNS:Order"
    // xmlns:myNS="urn:AnalyzeOrder"
    QName qn = new QName("http://service.unifBoss.iptvbss.newyulong.com", "deviceBind");
    // 注册类型映射 第一个参数为要传递的实体的CLASS类型，第二个为Qname,三四参数为串行化及反串行化工厂类看API可知 注册序列化和反序列化
    call.registerTypeMapping(
        DeviceBindReq.class,
        qn,
        new BeanSerializerFactory(DeviceBindReq.class, qn),
        new BeanDeserializerFactory(DeviceBindReq.class, qn));

    call.registerTypeMapping(
        ResultBean.class,
        qn,
        new BeanSerializerFactory(ResultBean.class, qn),
        new BeanDeserializerFactory(ResultBean.class, qn));

    call.setTargetEndpointAddress(endPoint);
    call.setOperationName("deviceBind");
    call.addParameter("deviceBindReq", qn, ParameterMode.IN);
    call.addParameter("sequenceID", qn, ParameterMode.IN);
    // 设置返回类型，些为javaBean故用setReturnClass
    call.setReturnClass(ResultBean.class);
    String result = "";

    call.invoke(new Object[] {deviceBindReq, getIfcSerialNo()});

    return result;
  }

  */
/**
   * mac地址解绑
   *
   * @param userID
   * @param regionName
   * @return
   * @throws ServiceException
   * @throws RemoteException
   *//*

  public String callUnBind(String userID, String regionName)
      throws ServiceException, RemoteException {
    // webService地址
    // webService地址使用华为的：广州,佛山,珠海,中山,江门,湛江,茂名,韶关,阳江,肇庆,清远,云浮

    // webService地址使用中兴的：深圳,东莞,汕头,惠州,揭阳,河源,梅州,汕尾,潮州

    // String endPoint="http://10.252.231.131:35000/BSS/services/BSS4BOSSServer";
    String endPoint = url1;
    if ("深圳,东莞,汕头,惠州,揭阳,河源,梅州,汕尾,潮州".contains(regionName)) {
      // endPoint="http://10.252.231.198:9346/BSS/services/BSS4BOSSServer";
      endPoint = url2;
    }
    // DeviceBindReq parseObject = JSON.parseObject(deviceBindReq,
    // DeviceBindReq.class);
    Service service = new Service();
    Call call;
    call = (Call) service.createCall();
    // QName由名称空间跟本地名称组成，看deploy.wsdd文件可知 <beanMapping qname="myNS:Order"
    // xmlns:myNS="urn:AnalyzeOrder"
    QName qn = new QName("http://service.unifBoss.iptvbss.newyulong.com", "unbind");
    // 注册类型映射 第一个参数为要传递的实体的CLASS类型，第二个为Qname,三四参数为串行化及反串行化工厂类看API可知 注册序列化和反序列化

    call.registerTypeMapping(
        ResultBean.class,
        qn,
        new BeanSerializerFactory(ResultBean.class, qn),
        new BeanDeserializerFactory(ResultBean.class, qn));
    call.setTargetEndpointAddress(endPoint);
    call.setOperationName("unbind");
    call.addParameter("userID", qn, ParameterMode.IN);
    call.addParameter("sequenceID", qn, ParameterMode.IN);

    // 设置返回类型，些为javaBean故用setReturnClass
    call.setReturnClass(ResultBean.class);
    String result = "";

    Object obj = call.invoke(new Object[] {userID, getIfcSerialNo()});
    if (obj != null) {
      result = JSON.toJSONString((ResultBean) obj);
    }
    return result;
  }

  */
/**
   * 电视激活状态查询
   *
   * @param userID
   * @param regionName
   * @return
   * @throws ServiceException
   * @throws RemoteException
   *//*

  public String queryUserInfoByUserID(String userID, String regionName)
      throws ServiceException, RemoteException {
    // webService地址
    // webService地址使用华为的：广州,佛山,珠海,中山,江门,湛江,茂名,韶关,阳江,肇庆,清远,云浮

    // webService地址使用中兴的：深圳,东莞,汕头,惠州,揭阳,河源,梅州,汕尾,潮州

    // String endPoint="http://10.252.231.131:35000/BSS/services/BSS4BOSSServer";
    String endPoint = "url1";
    if ("深圳,东莞,汕头,惠州,揭阳,河源,梅州,汕尾,潮州".contains(regionName)) {
      // endPoint="http://10.252.231.198:9346/BSS/services/BSS4BOSSServer";
      endPoint = url2;
    }
    // DeviceBindReq parseObject = JSON.parseObject(deviceBindReq,
    // DeviceBindReq.class);
    Service service = new Service();
    Call call;
    call = (Call) service.createCall();
    // QName由名称空间跟本地名称组成，看deploy.wsdd文件可知 <beanMapping qname="myNS:Order"
    // xmlns:myNS="urn:AnalyzeOrder"
    QName qn = new QName("http://service.unifBoss.iptvbss.newyulong.com", "queryUserInfoByUserID");
    // _call.setOperationName(new
    // javax.xml.namespace.QName("http://unifBoss.iptv.nyl.com",
    // "queryUserInfoByUserID"));

    // 注册类型映射 第一个参数为要传递的实体的CLASS类型，第二个为Qname,三四参数为串行化及反串行化工厂类看API可知 注册序列化和反序列化
    call.registerTypeMapping(
        QueryUserInfoByUserIDReq.class,
        qn,
        new BeanSerializerFactory(QueryUserInfoByUserIDReq.class, qn),
        new BeanDeserializerFactory(QueryUserInfoByUserIDReq.class, qn));

    call.registerTypeMapping(
        QueryUserInfoByUserIDResp.class,
        qn,
        new BeanSerializerFactory(QueryUserInfoByUserIDResp.class, qn),
        new BeanDeserializerFactory(QueryUserInfoByUserIDResp.class, qn));

    call.setTargetEndpointAddress(endPoint);
    call.setOperationName("queryUserInfoByUserID");
    call.addParameter("queryUserInfoByUserIDReq", qn, ParameterMode.IN);
    // call.addParameter("sequenceID", qn, ParameterMode.IN);
    // 设置返回类型，些为javaBean故用setReturnClass
    call.setReturnClass(QueryUserInfoByUserIDResp.class);
    String result = "";

    Object obj = call.invoke(new Object[] {userID, getIfcSerialNo()});
    if (obj != null) {
      result = JSON.toJSONString((QueryUserInfoByUserIDResp) obj);
    }
    return result;
  }

  public static String getIfcSerialNo() {
    return UUID.randomUUID().toString();
  }
}
*/
