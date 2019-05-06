package com.zyw.microservice.b.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.b.service.RibbonTestService;

@RestController
@RequestMapping(value="/zyw/ribbon/test")
public class RibbonTestController {
	
	@Autowired
	private RibbonTestService ribbonTestService;
	
	@RequestMapping(value="/consumer1",method=RequestMethod.GET)
	public String getMessage1() {
		String resultStr = ribbonTestService.getMessage1();
		return resultStr;
	}
	
	@RequestMapping(value="/consumer2",method=RequestMethod.GET)
	public String getMessage2() {
		String resultStr = ribbonTestService.getMessage2();
		return resultStr;
	}
	
}
