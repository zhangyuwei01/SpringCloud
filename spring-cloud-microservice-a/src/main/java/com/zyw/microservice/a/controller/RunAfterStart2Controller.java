package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.zyw.microservice.a.service.RunAfterStart2Service;

/**
 * @description 服务启动后，自动运行（实现ApplicationArguments接口）
 * @author ZhangYuWei
 * @create 2019-05-20
 */
@Component
@Order(value = 2) // 执行的先后顺序. 数字越小优先级越高
public class RunAfterStart2Controller implements ApplicationRunner {
	@Autowired
	private RunAfterStart2Service runAfterStart2Service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		runAfterStart2Service.runAfterStart();
	}

}
