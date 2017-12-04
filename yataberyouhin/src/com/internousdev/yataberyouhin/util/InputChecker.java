package com.internousdev.yataberyouhin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

	public boolean idChk(String id) {
		String regex = ".*[0-9A-Za-z]{4,}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(id);
		return m.find();
	}

	public boolean passwordChk(String password) {
		String regex = "(?=.*[0-9])(?=.*[a-zA-Z]).{6,}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.find();
	}

	public boolean telChk(String tel) {
		String regex = "[0-9]{2,4}-?[0-9]{3,4}-?[0-9]{3,4}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(tel);
		return m.find();
	}

	public boolean mailChk(String mail) {
		String regex = "[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mail);
		return m.find();
	}

}
