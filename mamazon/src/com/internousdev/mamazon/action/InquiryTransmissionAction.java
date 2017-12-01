package com.internousdev.mamazon.action;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 問い合わせ内容を送信する
 * @author internousdev
 *
 */
public class InquiryTransmissionAction extends ActionSupport {
	/**
	 * 問い合わせ者
	 */
	private String userName;

	/**
	 * 返信先アドレス
	 */
	private String mail;

	/**
	 * 問い合わせ本文
	 */
	private String text;

	/**
	 * 問い合わせ内容を送信する
	 */
	public String execute() {

	    String to = "ghbjy6@gmail.com";
	    String host = "smtp.gmail.com";
	    String title="mamazon問い合わせテスト";

	    //SMTPサーバを利用する
	    Properties property = new Properties();
        property.put("mail.smtp.auth", "true");
        property.put("mail.smtp.starttls.enable", "true");
        property.put("mail.smtp.host", host);
        property.put("mail.smtp.port", "587");
        property.put("mail.smtp.debug", "true");
	    Session session = Session.getInstance(property, new javax.mail.Authenticator() {
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication("internousdev", "internous01");
	    	}
	    });

	    try {
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(mail));
	        InternetAddress[] address = {new InternetAddress(to)};
	        msg.setRecipients(Message.RecipientType.TO, address);
	        ((MimeMessage)msg).setSubject(title,"ISO-2022-JP");
	        ((MimeMessage)msg).setText("問い合わせ者：" + userName + "\n" + "返信先メールアドレス：" + mail + "\n" + text,"ISO-2022-JP");
	        msg.setSentDate(new Date());

	        Transport.send(msg);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }

	    return SUCCESS;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param mail セットする from
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @param text セットする text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
