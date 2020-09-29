package com.esteel.user.mq.producer;

import com.esteel.annotation.rocketmq.MQ;
import com.esteel.annotation.rocketmq.Produce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName UserProducer.java
 * @Description TODO
 * @createTime 2020年5月20日 11:38
 */
@MQ
@Component
public class UserProducer {

    Logger logger = LoggerFactory.getLogger(UserProducer.class);

    /**
     * 生产者测试
     * @param
     * @return
     */
    @Produce(tags = "USER_TEST", topic = "TOPIC_USER")
    public String  userProducer(String userId){
        logger.info("【生产者】  userId = {}",userId);
        return userId;
    }
}
