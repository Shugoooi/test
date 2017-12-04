package com.internousdev.yataberyouhin.action;

import java.util.ArrayList;

import com.internousdev.yataberyouhin.util.ErrorMessageConstants;
import com.internousdev.yataberyouhin.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CheckUserInfoAction extends ActionSupport implements ErrorMessageConstants {

	private String familyName;

	private String firstName;

	private String familyNameKana;

	private String firstNameKana;

	/**
	 * 0:男性、1:女性
	 */
	private boolean sex;

	private String email;

	private String  userId;

	private String password;

	private ArrayList<String> errMsgList = new ArrayList<>();

	public String execute() {
		String result = SUCCESS;

		InputChecker i = new InputChecker();
		if (!i.familyNameChk(familyName)) {
			errMsgList.add(FAMILY_NAME_ERROR_MESSAGE);
			result = ERROR;
		}
		if (!i.firstNameChk(firstName)) {
			errMsgList.add(FIRST_NAME_ERROR_MESSAGE);
			result = ERROR;
		}
		if (!i.familyNameKanaChk(familyNameKana)) {
			errMsgList.add(FAMILY_NAME_KANA_ERROR_MESSAGE);
			result = ERROR;
		}
		if (!i.firstNameKanaChk(firstNameKana)) {
			errMsgList.add(FIRST_NAME_KANA_ERROR_MESSAGE);
			result = ERROR;
		}
		if (!i.emailChk(email)) {
			errMsgList.add(EMAIL_ERROR_MESSAGE);
			result = ERROR;
		}
		if (!i.userIdChk(userId)) {
			errMsgList.add(USER_ID_ERROR_MESSAGE);
			result = ERROR;
		}
		if (!i.passwordChk(password)) {
			errMsgList.add(PASSWORD_ERROR_MESSAGE);
			result = ERROR;
		}

		return result;
	}

	/**
	 * @return familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName セットする familyName
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return familyNameKana
	 */
	public String getFamilyNameKana() {
		return familyNameKana;
	}

	/**
	 * @param familyNameKana セットする familyNameKana
	 */
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	/**
	 * @return firstNameKana
	 */
	public String getFirstNameKana() {
		return firstNameKana;
	}

	/**
	 * @param firstNameKana セットする firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	/**
	 * @return sex
	 */
	public boolean isSex() {
		return sex;
	}

	/**
	 * @param sex セットする sex
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return errMsgList
	 */
	public ArrayList<String> getErrMsgList() {
		return errMsgList;
	}

	/**
	 * @param errMsgList セットする errMsgList
	 */
	public void setErrMsgList(ArrayList<String> errMsgList) {
		this.errMsgList = errMsgList;
	}
}
