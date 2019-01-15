package com.ccssoft;

import static org.apache.commons.httpclient.params.HttpMethodParams.SO_TIMEOUT;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtils {
  
  private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
  
  /**
   * 默认编码为 GB2312
   */
  private static final String HTTP_CONTENT_CHARSET = "gb2312";
  
  public static final Integer MAX_TIME_OUT = 5000;
  public static final Integer MAX_IDLE_TIME_OUT = 60000;
  public static final Integer MAX_CONN = 100;
  
  public static HttpClient httpClient ;
  
  static {
    MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
    connectionManager.closeIdleConnections(MAX_IDLE_TIME_OUT);
    connectionManager.getParams().setParameter("http.connection-manager.max-total", MAX_CONN);
    httpClient = new HttpClient(connectionManager);
    httpClient.getParams().setParameter(SO_TIMEOUT, MAX_TIME_OUT);
    httpClient.getParams().setParameter("http.connection.timeout", MAX_TIME_OUT);
    httpClient
        .getParams()
        .setParameter("http.connection-manager.timeout", MAX_TIME_OUT.longValue());
  }
  
  /**
   * 发送HTTP请求
   *
   * @return HTTP响应
   */
  public static String post(String url, Map<String, Object> param) {
    // HTTP方法，还有get,head,put,delete,connect,options（询问可用的选项）
    PostMethod post = new PostMethod(url);
    post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, HTTP_CONTENT_CHARSET);
    if (param != null) {
      for (Entry<String, Object> entry : param.entrySet()) {
        // 排除掉空值
        if (entry.getValue() != null) {
          post.addParameter(entry.getKey(), entry.getValue().toString());
        }
      }
    }
    try {
      post.addRequestHeader(new Header("Connection", "close"));
      // post.addRequestHeader("Cookie", "ID=1"); //添加Cookie
      httpClient.executeMethod(post);
      if (post.getStatusCode() == HttpStatus.SC_OK) {
        return post.getResponseBodyAsString();
      } else {
        post.abort(); // 马上断开连接
        logger.error("Http Comunication error ! code --> {}", post.getStatusCode(), null);
      }
    } catch (Exception e) {
      logger.error("Http post occur error!url=" + url + ",param=" + param, e);
    } finally {
      post.releaseConnection();
    }
    return null;
  }
  
  public static String doGet(String url, Map<String, Object> params) {
    String apiUrl = url;
    StringBuffer param = new StringBuffer();
    int i = 0;
    for (String key : params.keySet()) {
      if (i == 0) {
        param.append("?");
      } else {
        param.append("&");
      }
      param.append(key).append("=").append(params.get(key));
      i++;
    }
    apiUrl += param;
    String result = null;
    ////  HttpClient httpclient = new DefaultHttpClient();
    // CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      // HttpGet httpPost = new HttpGet(apiUrl);
      GetMethod get = new GetMethod(apiUrl);
      get.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
      // HttpResponse response = ;
      httpClient.executeMethod(get);
      if (get.getStatusCode() == HttpStatus.SC_OK) {
        return get.getResponseBodyAsString();
      } else {
        get.abort(); // 马上断开连接
        logger.error("Http Comunication error ! code -->{}", get.getStatusCode(), null);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
  
  // sso退出时的调用   有特殊的header   不通用
  public static String doPost(
      String url, Map<String, Object> param, String token, String jsonContent) {
    // HTTP方法，还有get,head,put,delete,connect,options（询问可用的选项）
    PostMethod post = new PostMethod(url);
    post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
    if (param != null) {
      for (Entry<String, Object> entry : param.entrySet()) {
        // 排除掉空值
        if (entry.getValue() != null) {
          post.addParameter(entry.getKey(), entry.getValue().toString());
        }
      }
    }
    
    try {
      RequestEntity requestEntity =
          new StringRequestEntity(jsonContent, "application/json", "utf-8");
      post.setRequestEntity(requestEntity);
      post.addRequestHeader(new Header("Connection", "close"));
      post.addRequestHeader(new Header("Authorization", "bearer " + token));
      post.addRequestHeader(new Header("Content-Type", "application/json"));
      // post.addRequestHeader("Cookie", "ID=1"); //添加Cookie
      logger.info("请求体：" + post.getRequestEntity());
      httpClient.executeMethod(post);
      logger.info("返回体：" + post.getResponseBodyAsString());
      if (post.getStatusCode() == HttpStatus.SC_OK) {
        return post.getResponseBodyAsString();
      } else {
        post.abort(); // 马上断开连接
        logger.error("Http Comunication error ! code -->{} ", post.getStatusCode(), null);
      }
    } catch (UnsupportedEncodingException e) {
      logger.error("Http post occur error!url=" + url + ",param=" + param, e);
    } catch (IOException e) {
      logger.error("Http post occur error!url=" + url + ",param=" + param, e);
    } finally {
      post.releaseConnection();
    }
    return null;
  }
  
  public static String doGetLogger(String url, Map<String, Object> params, String token) {
    String apiUrl = url;
    StringBuffer param = new StringBuffer();
    int i = 0;
    if (params != null) {
      for (String key : params.keySet()) {
        if (i == 0) {
          param.append("?");
        } else {
          param.append("&");
        }
        param.append(key).append("=").append(params.get(key));
        i++;
      }
    }
    
    apiUrl += param;
    String result = null;
    try {
      GetMethod get = new GetMethod(apiUrl);
      get.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
      get.addRequestHeader(new Header("Connection", "close"));
      get.addRequestHeader(new Header("Authorization", "bearer " + token));
      get.addRequestHeader(new Header("Content-Type", "application/json"));
      httpClient.executeMethod(get);
      String responseBody = get.getResponseBodyAsString();
      logger.info("get返回体：{}", responseBody);
      JSONObject json = JSON.parseObject(responseBody);
      logger.info(
          "返回结果:[code:" + json.getString("code") + ",message:" + json.getString("message") + "]");
      if (get.getStatusCode() == HttpStatus.SC_OK) {
        logger.info("日志接口记录成功");
        return responseBody;
      } else {
        get.abort(); // 马上断开连接
        logger.error("Http Comunication error ! code -->{} ", get.getStatusCode(), null);
      }
    } catch (Exception e) {
      logger.error("Http get occur error!url=" + url + ",param=" + param, e);
    }
    return result;
  }
  
  public static void main(String[] args) {
    // String url = "http://gc.ditu.aliyun.com/geocoding";
    String url = "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
    
    Map<String, Object> paramMap = new HashMap<String, Object>();
    
    paramMap.put("tel", "15136117986");
    String re = HttpClientUtils.doGet(url, paramMap);
    System.out.println(re);
  }
}
