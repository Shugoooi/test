package com.internousdev.mamazon.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dto.UserDTO;
import com.internousdev.mamazon.util.MyErrorConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 購入確認画面へ飛ぶ
 * @author internousdev
 *
 */
public class GoBuyConfirmAction extends ActionSupport implements SessionAware, MyErrorConstants {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * ログイン要求メッセージ
	 */
	private String loginRequired = null;

	/**
	 * 購入確認画面へ飛ぶ
	 */
	public String execute() {

		if(session.containsKey("userInfo")) {
			if( ((UserDTO) session.get("userInfo")).getLoginFlg() ) {
				return SUCCESS;
			}
		}

		 loginRequired = LOGIN_REQUIRED_MESSAGE;
		return "loginRequired";
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return loginRequired
	 */
	public String getLoginRequired() {
		return loginRequired;
	}
}
