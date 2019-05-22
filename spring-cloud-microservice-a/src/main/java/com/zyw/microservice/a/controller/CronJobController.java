package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zyw.microservice.a.service.CronJobService;

/**
 * @description 定时任务的Controler
 * @author ZhangYuWei
 * @create 2019-05-21
 */
@Component
public class CronJobController {
	@Autowired
	private CronJobService cronJobService;

	@Scheduled(cron = "0 0 20 * * ?")
	public void automaticScheduler() {
		cronJobService.automaticScheduler();
	}

}
