package com.zyw.microservice.b.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	/**
	 * @description 跨工程调用
	 */
	@Bean
	@LoadBalanced //Ribbon客户端负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
