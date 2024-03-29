package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.service.RedisService;
import com.zyw.microservice.a.vo.RedisVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description Redis操作的Controler
 * @author ZhangYuWei
 * @create 2019-05-07
 */
@RestController
@RequestMapping(value="/a/redis")
@Api(tags = "Redis")
public class RedisControler {
	@Autowired
	private RedisService redisService;
	
	@PostMapping(value="/add")
	@ApiOperation(value = "Redis新增数据", notes = "参数是：Redis的key、value")
	public RestResponse add(@RequestBody RedisVo redisVo) {
		return redisService.add(redisVo);
	}
	
	@GetMapping(value="/delete")
	@ApiOperation(value = "Redis删除数据", notes = "参数是：Redis的key")
	public RestResponse delete(@RequestParam String key) {
		return redisService.delete(key);
	}
	
	@GetMapping(value="/find")
	@ApiOperation(value = "Redis获取数据", notes = "参数是：Redis的key")
	public RestResponse find(@RequestParam String key) {
		return redisService.find(key);
	}
	
	@GetMapping(value="/refresh")
	@ApiOperation(value = "Redis刷新数据有效期", notes = "参数是：Redis的key")
	public RestResponse refresh(@RequestParam String key) {
		return redisService.refresh(key);
	}
	
	@PostMapping(value="/addObject")
	@ApiOperation(value = "Redis新增对象", notes = "参数是：VO对象")
	public RestResponse addObject(@RequestBody RedisVo redisVo) {
		return redisService.addObject(redisVo);
	}
	
	@GetMapping(value="/findObject")
	@ApiOperation(value = "Redis获取对象", notes = "参数是：Redis的key")
	public RestResponse findObject(@RequestParam String uuid) {
		return redisService.findObject(uuid);
	}
	
}
