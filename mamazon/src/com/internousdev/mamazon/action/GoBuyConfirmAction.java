package com.internousdev.mamazon.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 購入確認画面へ飛ぶ
 * @author internousdev
 *
 */
public class GoBuyConfirmAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * 購入確認画面へ飛ぶ
	 */
	public String execute() {

		if(session.containsKey("loginFlg")) {
			if( (Boolean) session.get("loginFlg") ) {
				return SUCCESS;
			}
		}

		return "loginRequired";
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
