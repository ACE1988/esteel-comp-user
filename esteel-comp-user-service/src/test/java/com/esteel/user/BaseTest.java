package com.esteel.user;

import com.esteel.user.entity.admin.AdminUser;
import com.esteel.user.service.AdminUserService;
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
    AdminUserService adminUserService ;

    @Test
    public void queryUser(){

        AdminUser adminUser = adminUserService.queryAdminUserByEmail("fn001@fn.com");
        System.out.println(adminUser.getEmail());
    }
}
