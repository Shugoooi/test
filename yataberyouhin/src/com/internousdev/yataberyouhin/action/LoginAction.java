package com.internousdev.yataberyouhin.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yataberyouhin.dao.LoginDAO;
import com.internousdev.yataberyouhin.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware {
	private String userId;
	private String password;
	private Map<String,Object> session;

public String execute() throws SQLException {
	String ret = ERROR;
	UserInfoDTO dto = new UserInfoDTO();
	LoginDAO dao = new LoginDAO();

	dto = dao.select(userId,password);
	if(userId.equals(dto.getUserId())) {
		if(password.equals(dto.getPassword())) {
			ret = SUCCESS;
		}
	}
	session.put("user_id", dto.getUserId());
	return ret;

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
 * @return session
 */
public Map<String, Object> getSession() {
	return session;
}

/**
 * @param session セットする session
 */
public void setSession(Map<String, Object> session) {
	this.session = session;
}

}
