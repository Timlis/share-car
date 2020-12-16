import com.ruoyi.RuoYiApplication;
import com.ruoyi.car.domain.CarCustomerExpand;
import com.ruoyi.car.service.ICarCustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class)
public class CustomerTest {
    @Autowired
    private ICarCustomerService carCustomerService;

    @Test
    public void customerTest(){
        CarCustomerExpand carCustomerExpand = carCustomerService.selectCarCustomerAllById(3L);
        System.out.println(carCustomerExpand);
    }
}
