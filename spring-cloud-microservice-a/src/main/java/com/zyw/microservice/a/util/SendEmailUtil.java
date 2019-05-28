package com.zyw.microservice.a.util;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @description 发送邮件的工具类
 * @author ZhangYuWei
 * @create 2019-05-21
 */
@Component
public class SendEmailUtil {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String username = "admin@foxmail.com";// 用户名
	private String password = "admin";// 密码
	private String host = "admin.foxmail.com";// 服务器地址
	private int port = 25;// 服务器端口

	private static String defaultencoding = "UTF-8";// 默认编码

	static {
		// 将Linux操作系统邮件附件名过长会被截断的属性，设置为false
		System.setProperty("mail.mime.splitlongparameters", "false");
	}

	/**
	 * @description 发送邮件---无附件
	 * @param frommail 发件人（必须开通与服务器地址对应的协议）
	 * @param bcc      抄送人（可以为空：null或""）
	 * @param subject  主题
	 * @param text     邮件内容
	 * @param tomail   收件人（多个邮箱之间用逗号间隔）
	 */
	public boolean sendMail(String frommail, String bcc, String subject, String text, String tomail) {
		logger.info("进入sendMail方法，参数是：frommail={},bcc={},subject={},text={},tomail={}",
				frommail, bcc, subject, text, tomail);
		try {
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
			// 设置服务器地址、端口
			senderImpl.setHost(host);
			senderImpl.setPort(port);
			// 设置邮件默认编码
			senderImpl.setDefaultEncoding(defaultencoding);
			// 设置登录用户、密码
			senderImpl.setUsername(username);
			senderImpl.setPassword(password);
			// 建立HTML邮件消息
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			
			// 设置utf-8或GBK编码，否则邮件会有乱码，true表示开始附件模式-multipart
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, defaultencoding);
			// 发件人
			messageHelper.setFrom(new InternetAddress(frommail));
			// 抄送人
			if (bcc != null && !bcc.trim().equals("")) {
				messageHelper.setBcc(InternetAddress.parse(bcc));
			}
			// 收件人
			messageHelper.setTo(InternetAddress.parse(tomail));
			// 标题
			messageHelper.setSubject(subject);
			// 内容，true 表示启动HTML格式的邮件
			messageHelper.setText(text, true);
			// 发送邮件
			senderImpl.send(mailMessage);
		} catch (Exception me) {
			logger.error("sendMail方法发生异常：{}", me.getMessage(), me);
			return false;
		}
		return true;
	}

	/**
	 * @description 发送邮件---单附件
	 * @param frommail 发件人（必须开通与服务器地址对应的协议）
	 * @param bcc      抄送人（可以为空：null或""）
	 * @param subject  主题
	 * @param text     邮件内容
	 * @param tomail   收件人（多个邮箱之间用逗号间隔）
	 * @param filename 附件文件名称
	 * @param filepath 附件文件路径
	 */
	public boolean sendFileMail(String frommail, String bcc, String subject, String text, String tomail,
			String filename, String filepath) {
		logger.info("进入sendFileMail方法，参数是：frommail={},bcc={},subject={},text={},tomail={},filename={},filepath={}",
				frommail, bcc, subject, text, tomail, filename, filepath);
		try {
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
			// 设置服务器地址、端口
			senderImpl.setHost(host);
			senderImpl.setPort(port);
			// 设置邮件默认编码
			senderImpl.setDefaultEncoding(defaultencoding);
			// 设置登录用户、密码
			senderImpl.setUsername(username);
			senderImpl.setPassword(password);
			// 建立HTML邮件消息
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			
			// 设置utf-8或GBK编码，否则邮件会有乱码，true表示开始附件模式-multipart
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, defaultencoding);
			// 发件人
			messageHelper.setFrom(new InternetAddress(frommail));
			// 抄送人
			if (bcc != null && !bcc.trim().equals("")) {
				messageHelper.setBcc(InternetAddress.parse(bcc));
			}
			// 收件人
			messageHelper.setTo(InternetAddress.parse(tomail));
			// 标题
			messageHelper.setSubject(subject);
			// 内容，true 表示启动HTML格式的邮件
			messageHelper.setText(text, true);
			// 文件路径
			FileSystemResource file = new FileSystemResource(new File(filepath));
			messageHelper.addAttachment(MimeUtility.encodeWord(filename), file);
			// 发送邮件
			senderImpl.send(mailMessage);
		} catch (Exception me) {
			logger.error("sendFileMail方法发生异常：{}", me.getMessage(), me);
			return false;
		}
		return true;
	}

	/**
	 * @description 发送邮件---多附件
	 * @param frommail    发件人（必须开通与服务器地址对应的协议）
	 * @param bcc         抄送人（可以为空：null或""）
	 * @param subject     主题
	 * @param text        邮件内容
	 * @param tomail      收件人（多个邮箱之间用逗号间隔）
	 * @param attachments 附件Map<String filename,String filepath>
	 */
	public boolean sendFileMailAttachments(String frommail, String bcc, String subject, String text, String tomail,
			List<Map<String, String>> attachments) {
		logger.info("进入sendFileMail方法，参数是：frommail={},bcc={},subject={},text={},tomail={},attachments={}",
				frommail, bcc, subject, text, tomail, attachments);
		try {
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
			// 设置服务器地址、端口
			senderImpl.setHost(host);
			senderImpl.setPort(port);
			// 设置邮件默认编码
			senderImpl.setDefaultEncoding(defaultencoding);
			// 设置登录用户、密码
			senderImpl.setUsername(username);
			senderImpl.setPassword(password);
			// 建立HTML邮件消息
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			
			// 设置utf-8或GBK编码，否则邮件会有乱码，true表示开始附件模式-multipart
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, defaultencoding);
			// 发件人
			messageHelper.setFrom(new InternetAddress(frommail));
			// 抄送人
			if (bcc != null && !bcc.trim().equals("")) {
				messageHelper.setBcc(InternetAddress.parse(bcc));
			}
			// 收件人
			messageHelper.setTo(InternetAddress.parse(tomail));
			// 标题
			messageHelper.setSubject(subject);
			// 内容，true 表示启动HTML格式的邮件
			messageHelper.setText(text, true);
			// 文件路径
			for (Map<String, String> attachment : attachments) {
				FileSystemResource file = new FileSystemResource(new File(attachment.get("filepath")));
				messageHelper.addAttachment(MimeUtility.encodeText(attachment.get("filename")), file);
			}
			// 发送邮件
			senderImpl.send(mailMessage);
		} catch (Exception me) {
			logger.error("sendFileMailAttachments方法发生异常：{}", me.getMessage(), me);
			return false;
		}
		return true;
	}

}
