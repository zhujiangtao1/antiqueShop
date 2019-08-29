import com.sailing.entity.Order;
import com.sailing.service.OrderInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:spring-config.xml",
       }
)
public class TestMapper {
   /* public static void main(String[] args) {
        Order order=new Order();
       String antid="1";
       String uid="49133";

        OrderInfoService orderInfoService=new OrderInfoService() {
        };
        orderInfoService.selectByuidAndantid(uid,antid);
    }
*/
    @Autowired
    private OrderInfoService orderInfoService;

   @Test
    public void selectByuidAndantid(){

       orderInfoService.selectByuidAndantid("","");
   }
}
