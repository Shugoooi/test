package com.internousdev.mamazon.dto;


/**
 * ユーザ情報を格納
 * @author internousdev
 *
 */
public class UserDTO {

	/**
	 * ID
	 */
	private String id;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザーネーム
	 */
	private String userName;

	/**
	 * 電話番号
	 */
	private int tel;

	/**
	 * メアド
	 */
	private String mail;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * ログインフラグ
	 */
	private boolean loginFlg = false;

	/**
	 * IDの取得
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * パスワードの取得
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ユーザーネームの取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 電話番号の取得
	 * @return tel
	 */
	public int getTel() {
		return tel;
	}

	/**
	 * メアドの取得
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 住所の取得
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * ログインフラグの取得
	 * @return loginFlg
	 */
	public boolean getLoginFlg() {
		return loginFlg;
	}

	/**
	 * @param loginFlg セットする loginFlg
	 */
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

	/**
	 * ユーザーネーム、ID、パスワード、電話番号、メアド、住所の順にセット
	 * @param userName
	 * @param id
	 * @param password
	 * @param tel
	 * @param mail
	 * @param address
	 */
	public void setUserInfo(String userName, String id, String password, int tel, String mail, String address) {
		this.userName = userName;
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.mail = mail;
		this.address = address;
	}

	/**
	 *	ID、パスワード、ユーザーネームの順にセット
	 * @param id
	 * @param password
	 * @param userName
	 */
	public void setUserInfo(String id, String password, String userName) {
		this.id = id;
		this.password = password;
		this.userName = userName;
	}
}
