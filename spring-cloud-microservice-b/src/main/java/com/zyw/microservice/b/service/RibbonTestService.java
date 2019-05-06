package com.zyw.microservice.b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonTestService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public String getMessage1() {
		String url = "http://microservice-a/spring-cloud/zyw/demo/discovery/client";
		String resultStr = restTemplate.getForObject(url, String.class);
		return resultStr;
	}
	
	public String getMessage2() {
		String url = "http://microservice-a/spring-cloud/zyw/demo/discovery/client";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String resultStr = response.getBody();
		return resultStr;
	}
	
}
