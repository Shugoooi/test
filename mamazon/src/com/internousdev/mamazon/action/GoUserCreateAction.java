package com.internousdev.mamazon.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 新規アカウント作成画面へ飛ぶ
 * @author internousdev
 *
 */
public class GoUserCreateAction extends ActionSupport {

	/**
	 * 新規登録ネーム
	 */
	private String newName;


	/**
	 * 新規登録ID
	 */
	private String newId;

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
	 * 新規アカウント作成画面へ飛ぶ
	 */
	public String execute() {
		return SUCCESS;
	}


	/**
	 * @return newName
	 */
	public String getNewName() {
		return newName;
	}


	/**
	 * @param newName セットする newName
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}


	/**
	 * @return newId
	 */
	public String getNewId() {
		return newId;
	}


	/**
	 * @param newId セットする newId
	 */
	public void setNewId(String newId) {
		this.newId = newId;
	}


	/**
	 * @return newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}


	/**
	 * @param newPassword セットする newPassword
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	/**
	 * @return newTel
	 */
	public String getNewTel() {
		return newTel;
	}


	/**
	 * @param newTel セットする newTel
	 */
	public void setNewTel(String newTel) {
		this.newTel = newTel;
	}


	/**
	 * @return newMail
	 */
	public String getNewMail() {
		return newMail;
	}


	/**
	 * @param newMail セットする newMail
	 */
	public void setNewMail(String newMail) {
		this.newMail = newMail;
	}


	/**
	 * @return newAddress
	 */
	public String getNewAddress() {
		return newAddress;
	}


	/**
	 * @param newAddress セットする newAddress
	 */
	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}
}
