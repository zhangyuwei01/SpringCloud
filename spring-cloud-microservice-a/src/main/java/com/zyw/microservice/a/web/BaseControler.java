package com.zyw.microservice.a.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.service.BaseService;

@RestController
@RequestMapping(value="/zyw/demo/base")
public class BaseControler {
	@Autowired
	private BaseService baseService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		String str = baseService.test();
		return str;
	}
	
}
