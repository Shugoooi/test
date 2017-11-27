package com.internousdev.mamazon.action;

import com.internousdev.mamazon.util.MyErrorConstants;
import com.internousdev.mamazon.util.MyMatcher;
import com.opensymphony.xwork2.ActionSupport;

/**
 * アカウント情報の変更内容を確認する
 * @author internousdev
 *
 */
public class UserInfoModConfirmAction extends ActionSupport  implements MyErrorConstants {

	/**
	 * 新規登録ネーム
	 */
	private String newName;

	/**
	 * 新規登録パスワード
	 */
	private String newPassword;

	/**
	 * 新規登録電話番号
	 */
	private String newTel;

	/**
	 * 新規登録メールアドレス
	 */
	private String newMail;

	/**
	 * 新規登録住所
	 */
	private String newAddress;

	/**
	 * パスワードエラーメッセージ
	 */
	private String passwordErr = new String();

	/**
	 * 電話番号入力エラーメッセージ
	 */
	private String telErr = new String();

	/**
	 * メールアドレス入力エラーメッセージ
	 */
	private String mailErr = new String();

	/**
	 * アカウント情報の変更内容を確認する
	 * @return
	 */
	public String execute() {

		//入力されたものが使用できるものか確認
		MyMatcher m = new MyMatcher();
		if(! m.passwordChk(newPassword)) {
			passwordErr = PASSWORD_ERROR_MESSAGE;
		}
		if(! m.mailChk(newMail)) {
			mailErr = MAIL_ERROR_MESSAGE;
		}
		if(! m.telChk(newTel)) {
			telErr = TEL_ERROR_MESSAGE;
		}
		if(m.passwordChk(newPassword) && m.mailChk(newMail) && m.telChk(newTel)) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}


	/**
	 * @return newName
	 */
	public String getNewName() {
		return newName;
	}


	/**
	 * @return newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}


	/**
	 * @return newTel
	 */
	public String getNewTel() {
		return newTel;
	}


	/**
	 * @return newMail
	 */
	public String getNewMail() {
		return newMail;
	}


	/**
	 * @return newAddress
	 */
	public String getNewAddress() {
		return newAddress;
	}


	/**
	 * @param newName セットする newName
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}


	/**
	 * @param newPassword セットする newPassword
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	/**
	 * @param newTel セットする newTel
	 */
	public void setNewTel(String newTel) {
		this.newTel = newTel;
	}


	/**
	 * @param newMail セットする newMail
	 */
	public void setNewMail(String newMail) {
		this.newMail = newMail;
	}


	/**
	 * @param newAddress セットする newAddress
	 */
	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}


	/**
	 * @return passwordErr
	 */
	public String getPasswordErr() {
		return passwordErr;
	}


	/**
	 * @return telErr
	 */
	public String getTelErr() {
		return telErr;
	}


	/**
	 * @return mailErr
	 */
	public String getMailErr() {
		return mailErr;
	}
}
