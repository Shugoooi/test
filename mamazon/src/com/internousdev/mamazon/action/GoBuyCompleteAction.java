package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.PurchaseDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 購入完了する
 * @author internousdev
 *
 */
public class GoBuyCompleteAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * 購入完了する
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {
		//購入履歴を追加
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		purchaseDAO.setPurchaseHistories((ArrayList<CartInfoDTO>) session.get("cartInfo"));

		//購入したカート情報の消去
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartInfoDAO.delCartInfo(((UserDTO) session.get("userInfo")).getUserName());
		session.remove("cartInfo");
		return SUCCESS;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
