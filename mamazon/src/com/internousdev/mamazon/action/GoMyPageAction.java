package com.internousdev.mamazon.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * マイページへ飛ぶ
 * @author internousdev
 *
 */
public class GoMyPageAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * マイページのどの画面を映すか
	 */
	private String myPageDisplay = new String();

	/**
	 * カート内の合計金額
	 */
	private int totalPrice = 0;

	/**
	 * マイページへ飛ぶ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String execute() {

		//カート内の合計金額を計算
		if(myPageDisplay.equals("myCart")) {
			if(session.containsKey("cartInfo")) {
				for(CartInfoDTO dto : (ArrayList<CartInfoDTO>) session.get("cartInfo")) {
					totalPrice += dto.getPrice() * dto.getPurchaseCount();
				}
			}
		}
		return SUCCESS;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return myPageDisplay
	 */
	public String getMyPageDisplay() {
		return myPageDisplay;
	}

	/**
	 * @param myPageDisplay セットする myPageDisplay
	 */
	public void setMyPageDisplay(String myPageDisplay) {
		this.myPageDisplay = myPageDisplay;
	}

	/**
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}
}
