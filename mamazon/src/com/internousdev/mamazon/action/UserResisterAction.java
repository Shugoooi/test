package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 入力されたユーザー情報をDBに登録する
 * @author internousdev
 *
 */
public class UserResisterAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session = new HashMap<>();

	public String execute() throws SQLException {
		UserDAO dao = new UserDAO();
		dao.setUserInfo((UserDTO) session.get("newUser"));
		session.remove("newUser");

		return SUCCESS;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
