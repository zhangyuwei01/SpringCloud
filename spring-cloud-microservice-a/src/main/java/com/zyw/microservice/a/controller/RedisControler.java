package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.service.RedisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description Redis的Controler
 * @author ZhangYuWei
 * @create 2019-05-07
 */
@RestController
@RequestMapping(value="/zyw/demo/redis")
@Api(value = "Redis操作")
public class RedisControler {
	@Autowired
	private RedisService redisService;
	
	@RequestMapping(value="/set",method=RequestMethod.GET)
	@ApiOperation(value = "Redis赋值", notes = "无参数")
	public String set() {
		String str = redisService.set();
		return str;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ApiOperation(value = "Redis取值", notes = "无参数")
	public String get() {
		String str = redisService.get();
		return str;
	}
	
}
