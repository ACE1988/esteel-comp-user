package com.esteel.user;

import com.esteel.common.dubbo.DubboResponse;
import com.esteel.user.service.UserDubboService;
import com.esteel.user.service.request.admin.AddUserRequest;
import com.esteel.user.service.request.admin.LoginUserRequest;
import com.esteel.user.service.response.admin.UserResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName BaseTest.java
 * @Description TODO
 * @createTime 2020年5月20日 09:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class BaseTest {

    @Autowired
    UserDubboService userDubboService ;

    @Test
    public void queryUserTest(){

        AddUserRequest request = new AddUserRequest();
        request.setPassword("Aa123456");
        request.setMobile("13818620570");
        request.setSource(0);
        request.setUserName("测试");
        DubboResponse<UserResponse> response = userDubboService.addUser(request);
        System.out.println(response.getData());
    }

    @Test
    public void loginUserTest(){

        LoginUserRequest request = new LoginUserRequest();
        request.setPassword("Aa123456");
        request.setMobile("13818620570");
        DubboResponse<UserResponse> response = userDubboService.userLogin(request);
        System.out.println(response.getData());
    }
}
