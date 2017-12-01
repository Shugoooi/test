package com.internousdev.mamazon.action;

import java.sql.SQLException;

import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.util.MyErrorConstants;
import com.internousdev.mamazon.util.MyMatcher;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 新規アカウント情報を確認する
 * @author internousdev
 *
 */
public class UserCreateConfirmAction extends ActionSupport  implements MyErrorConstants {

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
	 * エラーメッセージ
	 */
	private String errMsg;

	/**
	 * ID入力エラー
	 */
	private String idErr;

	/**
	 * パスワード入力エラー
	 */
	private String passwordErr;

	/**
	 * 電話番号入力エラー
	 */
	private String telErr;

	/**
	 * メールアドレス入力エラー
	 */
	private String mailErr;


	/**
	 * 新規アカウント情報を確認する
	 * @return
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		//入力されたものが使用できるものか確認
		UserDAO dao = new UserDAO();
		if(! dao.idChk(newId)) {
			errMsg = ID_DUPLICATION_MESSAGE;
			return ERROR;
		}
		MyMatcher m = new MyMatcher();
		if(! m.idChk(newId)) {
			idErr = ID_ERROR_MESSAGE;
		}
		if(! m.passwordChk(newPassword)) {
			passwordErr = PASSWORD_ERROR_MESSAGE;
		}
		if(! m.mailChk(newMail)) {
			mailErr = MAIL_ERROR_MESSAGE;
		}
		if(! m.telChk(newTel)) {
			telErr = TEL_ERROR_MESSAGE;
		}
		if(m.idChk(newId) && m.passwordChk(newPassword) && m.mailChk(newMail) && m.telChk(newTel)) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}


	/**
	 * @param errMsg セットする errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}


	/**
	 * @param idErr セットする idErr
	 */
	public void setIdErr(String idErr) {
		this.idErr = idErr;
	}


	/**
	 * @param passwordErr セットする passwordErr
	 */
	public void setPasswordErr(String passwordErr) {
		this.passwordErr = passwordErr;
	}


	/**
	 * @param telErr セットする telErr
	 */
	public void setTelErr(String telErr) {
		this.telErr = telErr;
	}


	/**
	 * @param mailErr セットする mailErr
	 */
	public void setMailErr(String mailErr) {
		this.mailErr = mailErr;
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


	/**
	 * @return errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}


	/**
	 * @return idErr
	 */
	public String getIdErr() {
		return idErr;
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
