package com.zyw.microservice.a.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.util.RestUtils;
import com.zyw.microservice.a.vo.RedisVo;

/**
 * @description Redis的Service
 * @author ZhangYuWei
 * @create 2019-05-07
 */
@Service
public class RedisService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * @description Redis新增数据
	 */
	public RestResponse add(RedisVo redisVo) {
		logger.info("进入add方法，参数是：{}",redisVo);
		String key = redisVo.getKey();
		String value = redisVo.getValue();
		stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);
		return RestUtils.returnSuccess("OK");
	}
	
	/**
	 * @description Redis删除数据
	 */
	public RestResponse delete(String key) {
		logger.info("进入delete方法，参数是：key={}",key);
		boolean deleteSuccess = stringRedisTemplate.delete(key);
		if(deleteSuccess) {
			return RestUtils.returnSuccess("OK");
		}else {
			return RestUtils.returnFailure("删除失败！");
		}
	}
	
	/**
	 * @description Redis更新数据
	 */
	public RestResponse update(RedisVo redisVo) {
		logger.info("进入update方法，参数是：{}",redisVo);
		String key = redisVo.getKey();
		String valueOfRedis = stringRedisTemplate.opsForValue().get(key);
		if(valueOfRedis==null) {
			return RestUtils.returnFailure("没有这个数据，无法更新！");
		}
		String value = redisVo.getValue();
		stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);
		return RestUtils.returnSuccess("OK");
	}
	
	/**
	 * @description Redis获取数据
	 */
	public RestResponse find(String key) {
		logger.info("进入find方法，参数是：key={}",key);
		String value = stringRedisTemplate.opsForValue().get(key);
		if(value==null) {
			return RestUtils.returnFailure("没有这个数据！");
		}
		return RestUtils.returnSuccessWithString(value);
	}
	
	/**
	 * @description Redis刷新数据有效期
	 */
	public RestResponse refresh(String key) {
		logger.info("进入refresh方法，参数是：key={}",key);
		boolean expireSuccess = stringRedisTemplate.expire(key, 1, TimeUnit.MINUTES);
		if(expireSuccess) {
			return RestUtils.returnSuccess("OK");
		}else {
			return RestUtils.returnFailure("刷新数据有效期失败！");
		}
	}
	
}
