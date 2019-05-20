package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.zyw.microservice.a.service.RunAfterStart1Service;

/**
 * @description 服务启动后，自动运行（实现CommandLineRunner接口）
 * @author ZhangYuWei
 * @create 2019-05-20
 */
@Component
@Order(value = 1) // 执行的先后顺序. 数字越小优先级越高
public class RunAfterStart1Controller implements CommandLineRunner {
	@Autowired
	private RunAfterStart1Service runAfterStart1Service;

	@Override
	public void run(String... args) throws Exception {
		runAfterStart1Service.runAfterStart();
	}

}
