package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
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
	 * 購入金額
	 */
	private int totalPrice;

	/**
	 * カート
	 */
	private ArrayList<CartInfoDTO> cartList = new ArrayList<>();

	/**
	 * ログイン要求メッセージ
	 */
	private String loginRequired = null;

	/**
	 * （現在カートの中身を見るページからのみ）購入確認画面へ飛ぶ
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		//ログイン履歴があれば購入確認画面へ
		if(session.containsKey("loginFlg")) {
			if( (boolean) session.get("loginFlg") ) {

				//カートの商品情報をリストで拾ってきて、ついでにカート内の合計金額を計算する
				CartInfoDAO dao = new CartInfoDAO();
				for(CartInfoDTO dto : dao.getCartTMP()) {
					GoodsDAO goodsDAO = new GoodsDAO();
					GoodsDTO goodsDTO = goodsDAO.getGoodsInfo(dto.getGoodsName());
					dto.setGoodsInfo(goodsDTO);
					totalPrice += dto.totalGoodsPrice();
					cartList.add(dto);
				}
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
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @return cartList
	 */
	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	/**
	 * @return loginRequired
	 */
	public String getLoginRequired() {
		return loginRequired;
	}
}
