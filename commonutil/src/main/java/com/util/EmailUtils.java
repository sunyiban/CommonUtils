package com.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title EmailUtils -> Class
 * @Package CommonUtils -> com.util
 * @Description 邮件发送
 * @date 2018/9/6 16:47 
 */
public class EmailUtils {
	public static final String HOST_QQ_MAIL = "smtp.qq.com";
	public static final String HOST_163_MAIL = "smtp.163.com";
	public static final String HOST_SINA_MAIL = "smtp.sina.com";

	private String senderName;
	private String senderPwd;
	private String host;
	private int port;

	private EmailUtils(){}

	public EmailUtils(String senderName, String senderPwd, String host, int port) {
		this.senderName = senderName;
		this.senderPwd = senderPwd;
		this.host = host;
		this.port = port;
	}

	/**
	 * 发送简单的文本邮件
	 *
	 * @author sunyiban
	 * @date 2018/9/6 16:58
	 * @param accepter 收件人地址
	 * @param subject 标题
	 * @param msg 内容
	 */
	public void sendSimpleEmail(String accepter, String subject, String msg) throws Exception{
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setAuthentication(senderName, senderPwd);
		simpleEmail.setFrom(senderName, senderName, "UTF-8");
		simpleEmail.setHostName(host);
		simpleEmail.setSmtpPort(port);
		simpleEmail.addTo(accepter);
		simpleEmail.setSubject(subject);
		simpleEmail.setMsg(msg);
		simpleEmail.send();
	}

	/**
	 * 发送带附件的邮件
	 *
	 * @author sunyiban
	 * @date 2018/9/6 16:58
	 * @param accepter 收件人地址
	 * @param subject 标题
	 * @param msg 内容
	 * @param filePath 附件路径
	 */
	public void sendEmailWithAttach(String accepter, String subject, String msg, String filePath) throws Exception {
		// 附件
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(filePath);
		// 文件名和路径中文件保持一致
		attachment.setName(filePath.substring(filePath.lastIndexOf("/"), filePath.length()));
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		// 邮件
		MultiPartEmail simpleEmail = new MultiPartEmail();
		simpleEmail.setHostName(host);
		simpleEmail.setAuthentication(senderName, senderPwd);
		simpleEmail.setSmtpPort(port);
		simpleEmail.setFrom(senderName, senderName, "UTF-8");
		simpleEmail.addTo(accepter);
		simpleEmail.setSubject(subject);
		simpleEmail.setMsg(msg);
		simpleEmail.attach(attachment);
		simpleEmail.send();
	}

	/**
	 * 发送带附件的邮件
	 *
	 * @author sunyiban
	 * @date 2018/9/6 16:58
	 * @param accepter 收件人地址
	 * @param subject 标题
	 * @param msg 内容
	 * @param filePath 附件路径
	 * @param fileName 附件名，需要和传输的附件保持一直
	 * @param description 附件描述
	 */
	public void sendEmailWithAttach(String accepter, String subject, String msg, String filePath, String fileName, String description) throws Exception {
		// 附件
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(filePath);
		// 文件名和路径中文件保持一致
		attachment.setName(fileName);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription(description);
		// 邮件
		MultiPartEmail simpleEmail = new MultiPartEmail();
		simpleEmail.setHostName(host);
		simpleEmail.setAuthentication(senderName, senderPwd);
		simpleEmail.setSmtpPort(port);
		simpleEmail.setFrom(senderName, senderName, "UTF-8");
		simpleEmail.addTo(accepter);
		simpleEmail.setSubject(subject);
		simpleEmail.setMsg(msg);
		simpleEmail.attach(attachment);
		simpleEmail.send();
	}

	public static void main(String[] args) throws Exception {
		EmailUtils emailUtils = new EmailUtils("*********", "********", HOST_SINA_MAIL, 25);
		emailUtils.sendSimpleEmail("**********", "这是一封测试邮件", "这是测试邮件的内容");

//		emailUtils.sendEmailWithAttach("543902264@qq.com", "这是一封测试邮件", "这是测试邮件的内容", "E:/test.pdf");
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
