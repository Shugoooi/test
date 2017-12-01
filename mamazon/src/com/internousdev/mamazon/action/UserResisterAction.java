package com.internousdev.mamazon.action;

import java.sql.SQLException;

import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 入力されたユーザー情報をDBに登録する
 * @author internousdev
 *
 */
public class UserResisterAction extends ActionSupport {

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
	 * ユーザー登録をする
	 */
	public String execute() throws SQLException {
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		dto.setUserInfo(newName, newId, newPassword, newTel, newMail, newAddress);
		dao.setUserInfo(dto);

		return SUCCESS;
	}

	/**
	 * @return newName
	 */
	public String getNewName() {
		return newName;
	}

	/**
	 * @return newId
	 */
	public String getNewId() {
		return newId;
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

}
