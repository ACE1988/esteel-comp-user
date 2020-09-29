package com.esteel.user.mq.consumer;

import com.esteel.annotation.rocketmq.Action;
import com.esteel.annotation.rocketmq.Consume;
import com.esteel.annotation.rocketmq.MQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author liujie
 * @version 1.0.0
 * @ClassName UserConsumer.java
 * @Description TODO
 * @createTime 2020年5月20日 11:40
 */
@MQ
@Component
@Slf4j
public class UserConsumer {

    /**
     * 分配初审员
     * @param
     * @return
     */
    @Consume(tags = "USER_TEST", topic = "TOPIC_USER")
    @Transactional(rollbackFor = Exception.class)
    public Action userConsumerTest(String userId){

        log.info("【'MQ 测试'】 userId={}",userId);
        return Action.CommitMessage;
    }
}
