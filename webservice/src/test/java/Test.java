import com.ccssoft.webservice.ItmsClient;
import com.ccssoft.webservice.Sg2PbossWebServiceClient;
import com.ccssoft.webservice.WebserviceApplication;
import com.ccssoft.webservice.itms.Sg2ItmsClient;
import javax.annotation.Resource;
import javax.inject.Inject;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <br>
 * Date 2019/4/8 11:01<br>
 * Author Administrator<br>
 */
@SpringBootTest(classes = {WebserviceApplication.class})
@RunWith(SpringRunner.class)
public class Test {

  @Resource Sg2PbossWebServiceClient sg2PbossWebServiceClient;

  @Inject ItmsClient itmsClient;

  @Inject Sg2ItmsClient sg2ItmsClient;

  @org.junit.Test
  public void m1() {

    sg2PbossWebServiceClient.sendRequest();
  }

  @org.junit.Test
  public void testItms() throws Exception {

    itmsClient.call();
  }

  @org.junit.Test
  public void testSg2Itms() throws Exception {
    sg2ItmsClient.dealOrder(ItmsClient.body);
  }
}
