package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * アカウント情報を変更する
 * @author internousdev
 *
 */
public class UserResistrationModAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session;

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
	 * アカウント情報を変更する
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		dto.setUserInfo(newName, session.get("userId").toString(), newPassword, newTel, newMail, newAddress);
		dao.updateUserInfo(dto);
		session.replace("userName", newName);
		return SUCCESS;
	}


	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
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
