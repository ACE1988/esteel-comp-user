package com.esteel.user.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName RedisLock.java
 * @Description TODO
 * @createTime 2020年5月09日 18:20
 */

@Component
@Slf4j
public class RedisLock {
	@Autowired
    StringRedisTemplate redisTemplate;
	
	/**
	 * @param seconds 默认失效时间
	 * @return
	 */
	public boolean lock(int seconds) {
		try {
			return redisTemplate.opsForValue().setIfAbsent(getKey(), "", Duration.ofSeconds(seconds));
		} catch (Exception e) {
			log.info("获取redis锁异常{}", e);
		}
		return false;
	}
	public void unlock() {
		redisTemplate.delete(getKey());
	}
	private String getKey() {
		StackTraceElement lockMethodStack = Thread.currentThread().getStackTrace()[3];
		return lockMethodStack.getClassName().concat(".").concat(lockMethodStack.getMethodName()).concat(".lock");
	}
}
