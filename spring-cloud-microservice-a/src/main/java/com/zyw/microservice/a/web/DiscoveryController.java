package com.zyw.microservice.a.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.service.DiscoveryService;

@RestController
@RequestMapping(value="/zyw/demo/discovery")
public class DiscoveryController {
	@Autowired
    private DiscoveryService discoveryService;

    @RequestMapping(value="/client",method=RequestMethod.GET)
    public String doDiscoveryService(){
    	String result = discoveryService.doDiscoveryService();
    	return result;
    }
}
