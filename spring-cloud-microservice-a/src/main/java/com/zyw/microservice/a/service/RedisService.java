package com.zyw.microservice.a.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @description Redis的Service
 * @author ZhangYuWei
 * @create 2019-05-07
 */
@Service
public class RedisService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public String set() {
		logger.info("进入set方法...");
		String redisKey = "name";
		String redisValue = "zhangsan";
		redisTemplate.opsForValue().set(redisKey, redisValue, 1, TimeUnit.MINUTES);
		logger.info("redisKey：[{}],redisValue：[{}]",redisKey,redisValue);
		return "OK";
	}
	
	public String get() {
		logger.info("进入get方法...");
		String redisKey = "name";
		String redisValue = redisTemplate.opsForValue().get(redisKey);
		logger.info("redisKey：[{}],redisValue：[{}]",redisKey,redisValue);
		return redisValue;
	}
	
}
