package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.service.SendEmailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description 发送邮件的Controler
 * @author ZhangYuWei
 * @create 2019-05-21
 */
@RestController
@RequestMapping(value = "/a/sendEmail")
@Api(tags = "SendEmail")
public class SendEmailController {
	@Autowired
	private SendEmailService sendEmailService;

	@PostMapping(value = "/noAttachment")
	@ApiOperation(value = "发送邮件（无附件）", notes = "无参数")
	public RestResponse noAttachment() {
		return sendEmailService.noAttachment();
	}

	@PostMapping(value = "/withAttachment")
	@ApiOperation(value = "发送邮件（单附件）", notes = "无参数")
	public RestResponse withAttachment() {
		return sendEmailService.withAttachment();
	}

	@PostMapping(value = "/withAttachments")
	@ApiOperation(value = "发送邮件（多附件）", notes = "无参数")
	public RestResponse withAttachments() {
		return sendEmailService.withAttachments();
	}

}
