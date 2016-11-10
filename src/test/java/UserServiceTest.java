import com.springapp.mvc.bean.User;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by WH on 2016/11/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetAllUsers() {
        List<User> userList = userService.getAllUsers();
        System.out.println(userList);
    }
}
