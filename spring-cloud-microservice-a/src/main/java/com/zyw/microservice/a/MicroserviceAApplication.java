package com.zyw.microservice.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description 微服务A启动类
 * @author ZhangYuWei
 * @create 2019-05-06
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zyw.microservice.a.dao")
public class MicroserviceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAApplication.class, args);
	}

}
