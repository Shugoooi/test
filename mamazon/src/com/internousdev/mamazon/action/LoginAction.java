package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.UserDTO;
import com.internousdev.mamazon.util.MyErrorConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログインする
 * @author internousdev
 *
 */
public class LoginAction extends ActionSupport implements SessionAware, MyErrorConstants {

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * ログインID
	 */
	private String loginId;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/**
	 * ログインエラーメッセージ
	 */
	private String loginError = null;


	/**
	 * ログインする
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		//ログイン情報の取得
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.getUserInfo(loginId, loginPassword);

		//ログインを試みる
		if(dto.getLoginFlg()) {

			//userIdが「a」ならば管理者画面へ移る
			if(dto.getId().equals("a")) {
				return "admin";
			}

			//ログイン成功、ユーザー情報及びログインフラグをセッションへ保存
			session.put("userId", dto.getId());
			session.put("userName", dto.getUserName());
			if(session.containsKey("loginFlg")) {
				session.replace("loginFlg", dto.getLoginFlg());
			} else {
				session.put("loginFlg",  dto.getLoginFlg());
			}

			//ユーザーのカート情報を一時カートへ保存する、両カート間で商品が重複した場合はユーザーのカート情報が優先される
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			ArrayList<CartInfoDTO> cartList = new ArrayList<>();
			for( CartInfoDTO cartInfoDTO : cartInfoDAO.getCartInfo(dto.getId()) ) {
				cartList.add(cartInfoDTO);
			}
			for(CartInfoDTO cartInfoDTO : cartList) {
				CartInfoDAO createCartTMP = new CartInfoDAO();
				createCartTMP.createCartTMP();
				CartInfoDAO cartTMP = new CartInfoDAO();
				CartInfoDAO chkGoodsDuplication = new CartInfoDAO();
				if( chkGoodsDuplication.isAlreadyIntoCartTMP(cartInfoDTO.getGoodsName()) ) {
					cartTMP.updateTMPPurchaseCount(cartInfoDTO);
				} else {
					cartTMP.setCartTMP(cartInfoDTO);
				}
			}


			return SUCCESS;
		} else {

			//ログイン失敗、失敗を伝えながらログインページへ
			loginError = LOGIN_ERROR_MESSAGE;
			return ERROR;
		}
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @return loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * @param loginError セットする loginError
	 */
	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @param loginId セットする loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @param loginPassword セットする loginPassword
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * ログインエラーメッセージの取得
	 * @return loginError
	 */
	public String getLoginError() {
		return loginError;
	}


}
