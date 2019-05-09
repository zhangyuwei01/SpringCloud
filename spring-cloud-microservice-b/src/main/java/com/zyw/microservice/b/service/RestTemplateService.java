package com.zyw.microservice.b.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zyw.microservice.b.common.RestResponse;
import com.zyw.microservice.b.util.RestUtils;

/**
 * @description RestTemplate --> 调用微服务A的Service
 * @author ZhangYuWei
 * @update 2019-05-09
 */
@Service
public class RestTemplateService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * @description 消费者 - get请求：调用微服务A
	 */
	@SuppressWarnings("unchecked")
	public RestResponse consumerGet() {
		logger.info("进入consumerGet方法，无参数......");
		String url = "http://microservice-a/spring-cloud/a/restTemplate/producerGet?param1=1&param2=2";
		String body = null; //请求体
		HttpHeaders headers = new HttpHeaders(); //请求头
		headers.add("token", "abcdef"); //将token放到请求头中
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		
		ResponseEntity<RestResponse> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RestResponse.class);
		if(response.getStatusCodeValue() != 200) {
			return RestUtils.returnFailure("调用微服务A失败！");
		}
		if(!"200".equals(response.getBody().getStatus())) {
			return RestUtils.returnFailure("微服务A发生异常！");
		}
		Map<String,Object> returnMap = (Map<String,Object>) response.getBody().getData();
		return RestUtils.returnSuccess(returnMap);
	}
	
	/**
	 * @description 消费者 - post请求：调用微服务A
	 */
	@SuppressWarnings("unchecked")
	public RestResponse consumerPost() {
		logger.info("进入consumerPost方法，无参数......");
		String url = "http://microservice-a/spring-cloud/a/restTemplate/producerPost";
		Map<String,Object> body = new HashMap<>(); //请求体
		body.put("param1", 1);
		body.put("param2", 2);
		HttpHeaders headers = new HttpHeaders(); //请求头
		headers.add("token", "abcdef");
    	HttpEntity<Map<String,Object>> requestEntity = new HttpEntity<>(body, headers);
    	
    	ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, requestEntity, RestResponse.class);
		if(response.getStatusCodeValue() != 200) {
			return RestUtils.returnFailure("调用微服务A失败！");
		}
		if(!"200".equals(response.getBody().getStatus())) {
			return RestUtils.returnFailure("微服务A发生异常！");
		}
		Map<String,Object> returnMap = (Map<String,Object>) response.getBody().getData();
		return RestUtils.returnSuccess(returnMap);
	}
	
}
