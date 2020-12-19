package serviceTest;

import com.ruoyi.RuoYiApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class)
public class ShareCarTest {

    @Before
    public void init() {
        System.out.println("begin test-------");
    }

    public void after() {
        System.out.println("end test--------");
    }
}
