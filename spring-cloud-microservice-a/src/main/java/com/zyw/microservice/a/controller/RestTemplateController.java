package com.zyw.microservice.a.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.service.RestTemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description RestTemplate --> 供微服务B调用的Controler
 * @author ZhangYuWei
 * @update 2019-05-09
 */
@RestController
@RequestMapping(value="/a/restTemplate")
@Api(value = "RestTemplate")
public class RestTemplateController {
	@Autowired
    private RestTemplateService restTemplateService;

	@GetMapping(value="/producerGet")
	@ApiOperation(value = "生产者 - get请求", notes = "微服务B传过来的参数")
    public RestResponse producerGet(@RequestHeader String token,@RequestParam String param1,@RequestParam String param2){
    	return restTemplateService.producerGet(token,param1,param2);
    }
	
	@PostMapping(value="/producerPost")
	@ApiOperation(value = "生产者 - post请求", notes = "微服务B传过来的参数")
    public RestResponse producerPost(@RequestHeader String token,@RequestBody Map<String,Object> params){
    	return restTemplateService.producerPost(token,params);
    }
	
}
