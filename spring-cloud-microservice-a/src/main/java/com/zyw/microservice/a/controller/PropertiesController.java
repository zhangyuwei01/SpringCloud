package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.service.PropertiesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description 读取属性文件的Controler
 * @author ZhangYuWei
 * @create 2019-05-20
 */
@RestController
@RequestMapping(value = "/a/properties")
@Api(tags = "Properties")
public class PropertiesController {
	@Autowired
	private PropertiesService propertiesService;

	@GetMapping(value = "/get")
	@ApiOperation(value = "获取属性文件中的属性值", notes = "无参数")
	public RestResponse get() {
		return propertiesService.get();
	}

}
