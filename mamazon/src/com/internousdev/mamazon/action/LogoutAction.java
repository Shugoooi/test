/**
 *
 */
package com.internousdev.mamazon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ログアウトする
 * @author internousdev
 *
 */
public class LogoutAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	public String execute() {
		//ログインセッションを全て切断する
		session.remove("userName");
		session.remove("userId");
		session.replace("loginFlg", false);
		return SUCCESS;
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
