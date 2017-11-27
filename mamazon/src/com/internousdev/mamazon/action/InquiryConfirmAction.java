package com.internousdev.mamazon.action;

import com.internousdev.mamazon.util.MyErrorConstants;
import com.internousdev.mamazon.util.MyMatcher;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 問い合わせ内容を確認
 * @author internousdev
 *
 */
public class InquiryConfirmAction extends ActionSupport implements MyErrorConstants {

	/**
	 * 問い合わせの名前
	 */
	private String userName;

	/**
	 * 問い合わせ返信用メアド
	 */
	private String mail;

	/**
	 * メアド入力エラー
	 */
	private String mailErr;

	/**
	 * 問い合わせ内容
	 */
	private String inquiry;

	/**
	 * 問い合わせ内容を確認
	 */
	public String execute() {

		//メールアドレスの入力チェック
		MyMatcher m = new MyMatcher();
		if(m.mailChk(mail)) {
			return SUCCESS;
		} else {
			mailErr = MAIL_ERROR_MESSAGE;
			return ERROR;
		}

	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail セットする mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return inquiry
	 */
	public String getInquiry() {
		return inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	/**
	 * @return mailErr
	 */
	public String getMailErr() {
		return mailErr;
	}


}
