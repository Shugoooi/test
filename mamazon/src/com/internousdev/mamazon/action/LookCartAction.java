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
	 * カートリスト
	 */
	private ArrayList<CartInfoDTO> cartList = new ArrayList<>();

	/**
	 * カート内商品の合計金額
	 */
	private int totalPrice = 0;

	/**
	 * カートから外す商品
	 */
	private String deleteGoods = new String();


	/**
	 * カートの中身を確認する
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		//カート内の指定した商品(deleteGoods)があれば削除する
		if(!deleteGoods.isEmpty()) {
			CartInfoDAO cartInfoDAO2 = new CartInfoDAO();
			if(session.containsKey("loginFlg")) {
				if((boolean) session.get("loginFlg")) {
					CartInfoDAO cartInfoDAO = new CartInfoDAO();
					cartInfoDAO.delGoodsFromCartInfo(deleteGoods, session.get("userId").toString());
				}
			}
			cartInfoDAO2.delGoodsFromCartTMP(deleteGoods);
		}

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

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return cartList
	 */
	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	/**
	 * 購入額の総計を取得
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param deleteGoods セットする deleteGoods
	 */
	public void setDeleteGoods(String deleteGoods) {
		this.deleteGoods = deleteGoods;
	}
}
