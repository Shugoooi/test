package com.internousdev.mamazon.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dto.UserDTO;
import com.internousdev.mamazon.util.MyErrorConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * （現在カートの中身を見るページからのみ）購入確認画面へ飛ぶ
 * @author internousdev
 *
 */
public class GoPurchaseConfirmAction extends ActionSupport implements SessionAware, MyErrorConstants {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * ログイン要求メッセージ
	 */
	private String loginRequired = null;

	/**
	 * （現在カートの中身を見るページからのみ）購入確認画面へ飛ぶ
	 */
	public String execute() {

		//ログイン履歴があれば購入確認画面へ
		if(session.containsKey("userInfo")) {
			if( ((UserDTO) session.get("userInfo")).getLoginFlg() ) {
				return SUCCESS;
			}
		}
		//ログイン履歴がなければログイン画面へ
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
