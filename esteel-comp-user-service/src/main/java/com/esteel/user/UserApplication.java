package com.esteel.user;

import com.esteel.autoconfigure.EnableMQ;
import com.esteel.autoconfigure.EnableRedis;
import com.esteel.framework.annotation.EnableFramework;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName ApproveApplication.java
 * @Description TODO
 * @createTime 2020年5月09日 18:20
 */

@SpringBootApplication(scanBasePackages = {"com.esteel.framework.mybatis","com.esteel.user"})
@EnableFramework(daoPaths = {"com.esteel.user.dao"})
@Configuration
@EnableTransactionManagement
@EnableDubbo
@DubboComponentScan(basePackages = "com.esteel.user.dubbo.impl")
//@EnableMQ
@EnableRedis
@EnableScheduling
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
