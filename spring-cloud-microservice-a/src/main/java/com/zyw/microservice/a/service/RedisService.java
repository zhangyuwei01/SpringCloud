package com.zyw.microservice.a.service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.util.RestUtils;
import com.zyw.microservice.a.vo.RedisVo;

/**
 * @description Redis操作的Service
 * @author ZhangYuWei
 * @create 2019-05-07
 */
@Service
public class RedisService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
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
	
	/**
	 * @description Redis新增对象
	 */
	public RestResponse addObject(RedisVo redisVo) {
		logger.info("进入addObject方法，参数是：{}",redisVo);
		String uuid = UUID.randomUUID().toString();
		redisTemplate.opsForValue().set(uuid, redisVo, 1, TimeUnit.MINUTES);
		return RestUtils.returnSuccess("OK", uuid);
	}
	
	/**
	 * @description Redis获取对象
	 */
	public RestResponse findObject(String uuid) {
		logger.info("进入findObject方法，参数是：uuid={}",uuid);
		RedisVo redisVo = (RedisVo) redisTemplate.opsForValue().get(uuid);
		if(redisVo==null) {
			return RestUtils.returnFailure("没有这个对象！");
		}
		return RestUtils.returnSuccess(redisVo);
	}
	
}
