package com.internousdev.yataberyouhin.action;

import com.opensymphony.xwork2.ActionSupport;

public class CheckUserInfoAction extends ActionSupport {

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

	public String execute() {


	}
}
