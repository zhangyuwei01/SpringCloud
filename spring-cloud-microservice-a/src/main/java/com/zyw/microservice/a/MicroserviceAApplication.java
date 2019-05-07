package com.zyw.microservice.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description 服务启动类
 * @author ZhangYuWei
 * @create 2019-05-06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAApplication.class, args);
	}

}
