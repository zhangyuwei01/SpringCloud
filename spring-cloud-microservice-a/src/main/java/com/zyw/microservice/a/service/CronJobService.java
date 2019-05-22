package com.zyw.microservice.a.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description 定时任务的Service
 * @author ZhangYuWei
 * @create 2019-05-21
 */
@Component
public class CronJobService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @description 定时任务自动执行（每天的20点整触发定时器）
	 */
	public void automaticScheduler() {
		logger.info("进入automaticScheduler方法，无参数......");
	}

}
