package com.zyw.microservice.b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.b.common.RestResponse;
import com.zyw.microservice.b.service.RestTemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description RestTemplate --> 调用微服务A的Controler
 * @author ZhangYuWei
 * @update 2019-05-09
 */
@RestController
@RequestMapping(value="/b/restTemplate")
@Api(value = "RestTemplate")
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@GetMapping(value="/consumerGet")
	@ApiOperation(value = "消费者 - get请求", notes = "无参数")
	public RestResponse consumerGet() {
		return restTemplateService.consumerGet();
	}
	
	@GetMapping(value="/consumerPost")
	@ApiOperation(value = "消费者 - post请求", notes = "无参数")
	public RestResponse consumerPost() {
		return restTemplateService.consumerPost();
	}
	
}
