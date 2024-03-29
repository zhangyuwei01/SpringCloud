package com.zyw.microservice.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description 微服务B启动类
 * @author ZhangYuWei
 * @create 2019-05-06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceBApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBApplication.class, args);
	}

}
