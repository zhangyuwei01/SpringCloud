package com.zyw.microservice.a.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description 服务启动后，自动运行
 * @author ZhangYuWei
 * @create 2019-05-20
 */
@Component
public class RunAfterStart1Service {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @description 服务启动后，自动运行
	 */
	public void runAfterStart() {
		logger.info("进入RunAfterStart1Service的runAfterStart方法，无参数......");
	}

}
