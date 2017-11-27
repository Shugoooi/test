package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * アカウント情報変更画面へ飛ぶ
 * @author internousdev
 *
 */
public class GoUserInfoModAction extends ActionSupport implements SessionAware {


	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

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
	 * アカウント情報変更画面へ飛ぶ
	 * @return
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		//変更前のユーザー情報を格納する
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.getUserInfo(session.get("userId").toString());
		newName = dto.getUserName();
		newPassword = dto.getPassword();
		newTel = dto.getTel();
		newMail = dto.getMail();
		newAddress = dto.getAddress();

		return SUCCESS;
	}



	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
}
