package com.zyw.microservice.a.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.microservice.a.common.RestResponse;
import com.zyw.microservice.a.util.RestUtils;
import com.zyw.microservice.a.util.SendEmailUtil;

/**
 * @description 发送邮件的Service
 * @author ZhangYuWei
 * @create 2019-05-21
 */
@Service
public class SendEmailService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SendEmailUtil sendEmailUtil;

	/**
	 * @description 发送无附件的邮件
	 */
	public RestResponse noAttachment() {
		logger.info("进入noAttachment方法，无参数......");
		String frommail = "zhangyuwei@nantian.com.cn";// 发件人
		String bcc = null;// 抄送人
		String subject = "代发邮件";// 主题
		String text = "邮件发送通过web服务器代理发送，HR服务不直接连接公网";// 邮件内容
		String tomail = "zhangyuwei@nantian.com.cn";// 收件人

		Boolean sendSuccess = sendEmailUtil.sendMail(frommail, bcc, subject, text, tomail);
		if (!sendSuccess) {
			return RestUtils.returnFailure("邮件发送失败！");
		}
		return RestUtils.returnSuccess("邮件发送成功！");
	}

	/**
	 * @description 发送单附件的邮件
	 */
	public RestResponse withAttachment() {
		logger.info("进入withAttachment方法，无参数......");
		String frommail = "zhangyuwei@nantian.com.cn";// 发件人
		String bcc = null;// 抄送人
		String subject = "代发邮件";// 主题
		String text = "邮件发送通过web服务器代理发送，HR服务不直接连接公网";// 邮件内容
		String tomail = "zhangyuwei@nantian.com.cn";// 收件人
		String filename = "attachment.docx";// 附件名字
		String filepath = "/files/attachment.pdf";// 附件路径
		
		Boolean sendSuccess = sendEmailUtil.sendFileMail(frommail, bcc, subject, text, tomail, filename, filepath);
		if (!sendSuccess) {
			return RestUtils.returnFailure("邮件发送失败！");
		}
		return RestUtils.returnSuccess("邮件发送成功！");
	}

	/**
	 * @description 发送多附件的邮件
	 */
	public RestResponse withAttachments() {
		logger.info("进入withAttachments方法，无参数......");
		String frommail = "zhangyuwei@nantian.com.cn";// 发件人
		String bcc = null;// 抄送人
		String subject = "代发邮件";// 主题
		String text = "邮件发送通过web服务器代理发送，HR服务不直接连接公网";// 邮件内容
		String tomail = "zhangyuwei@nantian.com.cn";// 收件人
		
		List<Map<String, String>> attachmentsList = new ArrayList<>();// 多个附件的路径、名字
		Map<String, String> attachment1 = new HashMap<>();
		attachment1.put("filename", "attachment.docx");
		attachment1.put("filepath", "/files/attachment.docx");
		attachmentsList.add(attachment1);
		Map<String, String> attachment2 = new HashMap<>();
		attachment2.put("filename", "attachment.xlsx");
		attachment2.put("filepath", "/files/attachment.xlsx");
		attachmentsList.add(attachment2);
		Map<String, String> attachment3 = new HashMap<>();
		attachment3.put("filename", "attachment.pptx");
		attachment3.put("filepath", "/files/attachment.pptx");
		attachmentsList.add(attachment3);
		
		Boolean sendSuccess = sendEmailUtil.sendFileMailAttachments(frommail, bcc, subject, text, tomail,
				attachmentsList);
		if (!sendSuccess) {
			return RestUtils.returnFailure("邮件发送失败！");
		}
		return RestUtils.returnSuccess("邮件发送成功！");
	}

}
