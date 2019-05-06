package com.zyw.microservice.a.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.service.RedisService;

@RestController
@RequestMapping(value="/zyw/demo/redis")
public class RedisControler {
	@Autowired
	private RedisService redisService;
	
	@RequestMapping(value="/set",method=RequestMethod.GET)
	public String set() {
		String str = redisService.set();
		return str;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String get() {
		String str = redisService.get();
		return str;
	}
	
}
