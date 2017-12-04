package com.internousdev.yataberyouhin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

	public boolean familyNameChk(String familyName) {
		String regex = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(familyName);
		return m.find();
	}


	public boolean firstNameChk(String firstName) {
		String regex = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(firstName);
		return m.find();
	}


	public boolean familyNameKanaChk(String familyNameKana) {
		String regex = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(familyNameKana);
		return m.find();
	}


	public boolean firstNameKanaChk(String firstNameKana) {
		String regex = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(firstNameKana);
		return m.find();
	}


	public boolean emailChk(String email) {
		String regex = "[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.find();
	}


	public boolean userIdChk(String userId) {
		String regex = ".*[0-9A-Za-z]{4,}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(userId);
		return m.find();
	}



	public boolean passwordChk(String password) {
		String regex = "(?=.*[0-9])(?=.*[a-zA-Z]).{6,}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.find();
	}

}
