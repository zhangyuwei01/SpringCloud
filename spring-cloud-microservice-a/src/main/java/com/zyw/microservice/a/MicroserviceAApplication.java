package com.zyw.microservice.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description 微服务A启动类
 * @author ZhangYuWei
 * @create 2019-05-06
 */
@SpringBootApplication
@EnableDiscoveryClient // 注册到Eureka上去
@MapperScan("com.zyw.microservice.a.dao") // Mybatis扫描DAO类
@EnableScheduling // 开启定时任务
public class MicroserviceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAApplication.class, args);
	}

}
