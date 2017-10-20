package com.internousdev.mamazon.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * アカウント情報の変更内容を確認する
 * @author internousdev
 *
 */
public class UserInfoModConfirmAction extends ActionSupport  implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

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
	private int newTel;

	/**
	 * 新規登録メールアドレス
	 */
	private String newMail;

	/**
	 * 新規登録住所
	 */
	private String newAddress;

	/**
	 * アカウント情報の変更内容を確認する
	 * @return
	 */
	public String execute() {

		//入力したユーザー情報をセッションへ保存する
		UserDTO userDTO = new UserDTO();
		userDTO.setUserInfo(newName, newId, newPassword, newTel, newMail, newAddress);
		session.put("newUser",  userDTO);

		return SUCCESS;
	}


	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	/**
	 * @param newName セットする newName
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}


	/**
	 * @param newId セットする newId
	 */
	public void setNewId(String newId) {
		this.newId = newId;
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
	public void setNewTel(int newTel) {
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
}
