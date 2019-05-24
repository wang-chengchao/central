import com.ccssoft.webservice.Sg2PbossWebServiceClient;
import com.ccssoft.webservice.WebserviceApplication;
import javax.annotation.Resource;
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
  
  @Resource
  Sg2PbossWebServiceClient sg2PbossWebServiceClient;
  
  @org.junit.Test
  public void m1(){
    
    sg2PbossWebServiceClient.sendRequest();
  }
  
}