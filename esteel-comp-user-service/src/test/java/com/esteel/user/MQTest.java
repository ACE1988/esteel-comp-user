package com.esteel.user;

import com.esteel.user.mq.producer.UserProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName MQTest.java
 * @Description TODO
 * @createTime 2020年5月20日 14:00
 */
public class MQTest extends BaseTest {

    @Autowired
    UserProducer producer ;

    @Test
    public void mqTest (){
        producer.userProducer("10001");
    }
}
