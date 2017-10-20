package com.internousdev.mamazon.action;

import java.util.HashMap;
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

	private Map<String, Object> session = new HashMap<>();

	/**
	 * アカウント情報を変更する
	 */
	public String execute() {
		UserDAO dao = new UserDAO();
		dao.setUserInfo((UserDTO) session.get("newUser"));
		return SUCCESS;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
