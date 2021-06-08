package net.xdclass.demoproject;

import junit.framework.TestCase;
import net.xdclass.demoproject.controller.UserController;
import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.utils.JsonData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //底层⽤junit SpringJUnit4ClassRunner
@SpringBootTest(classes = {DemoProjectApplication.class})//启动整个springboot⼯程
public class UserTest {

    @Autowired
    UserController userController;

    @Test
    public void loginTest() {
        User user = new User();
        user.setPwd("jack1234");
        user.setUserName("jack");
        JsonData login = userController.login(user);
        System.out.println(login.toString());
        TestCase.assertEquals(0, login.getCode());
    }
}
