package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 問い合わせ画面へ飛ぶ
 * @author internousdev
 *
 */
public class GoInquiryAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * メアド（ログインしていたらユーザー情報から持ってくる）
	 */
	private String mail = new String();


	/**
	 * 問い合わせ画面へ飛ぶ
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		//ログインフラグが立ってたらその情報をフォームへ格納する
		if( session.containsKey("loginFlg") ) {
			if( (boolean) session.get("loginFlg") ) {
				UserDAO dao = new UserDAO();
				UserDTO dto = dao.getUserInfo( session.get("userId").toString() );
				mail = dto.getMail();
			}
		}
		return SUCCESS;
	}
	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
