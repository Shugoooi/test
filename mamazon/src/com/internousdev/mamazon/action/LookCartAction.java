package com.internousdev.mamazon.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カートの中身を確認するクラス
 * @author internousdev
 *
 */
public class LookCartAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * カート内商品の合計金額
	 */
	private int totalPrice = 0;


	/**
	 * カートの中身を確認する
	 */
	@SuppressWarnings("unchecked")
	public String execute() {

		if(session.containsKey("cartInfo")) {
			for(CartInfoDTO dto :  (ArrayList<CartInfoDTO>)session.get("cartInfo")) {
				totalPrice += dto.totalGoodsPrice();
			}
			session.put("totalPrice", totalPrice);
		}

		return SUCCESS;
	}

	/**
	 * セッションのセット
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * 購入額の総計を取得
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}
}
