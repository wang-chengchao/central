package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.ccssoft.Application;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoApplicationTests {

  static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

  // 端口
  static final long PORT = 9500;
  // clientId
  static final String CLIENT_ID = "merryyou";
  // clientSecret
  static final String CLIENT_SECRET = "merryyou";
  // 用户名
  static final String USERNAME = "admin";
  // 密码
  static final String PASSWORD = "123456";
  // 获取accessToken得URI
  static final String TOKEN_REQUEST_URI =
      "http://localhost:"
          + PORT
          + "/oauth/token?grant_type=password&username="
          + USERNAME
          + "&password="
          + PASSWORD
          + "&scope=all";
  // 获取用户信息得URL
  static final String USER_INFO_URI = "http://localhost:" + PORT + "/user";

  @Test
  public void getUserInfo()  {
    RestTemplate rest = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("authorization", "Bearer "+getAccessToken());
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    // pay attention, if using get with headers, should use exchange instead of getForEntity /
    // getForObject
    ResponseEntity<String> result =
        rest.exchange(USER_INFO_URI, HttpMethod.GET, entity, String.class, new Object[] {null});
    log.info("用户信息返回的结果={}", JSON.toJSONString(result));
  }

  /**
   * 获取accessToken
   *
   * @return
   */
  private String getAccessToken() {
    RestTemplate rest = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);
    headers.add("authorization", getBasicAuthHeader());
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    ResponseEntity<OAuth2AccessToken> resp =
        rest.postForEntity(TOKEN_REQUEST_URI, entity, OAuth2AccessToken.class);
    if (!resp.getStatusCode().equals(HttpStatus.OK)) {
      throw new RuntimeException(resp.toString());
    }
    OAuth2AccessToken t = resp.getBody();
    log.info("accessToken={}", JSON.toJSONString(t));
    log.info(
        "the response, access_token: "
            + t.getValue()
            + "; token_type: "
            + t.getTokenType()
            + "; "
            + "refresh_token: "
            + t.getRefreshToken()
            + "; expiration: "
            + t.getExpiresIn()
            + ", expired when:"
            + t.getExpiration());
    return t.getValue();
  }

  /**
   * 构建header
   *
   * @return
   */
  private String getBasicAuthHeader() {
    String auth = CLIENT_ID + ":" + CLIENT_SECRET;
    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
    String authHeader = "Basic " + new String(encodedAuth);
    return authHeader;
  }
}
