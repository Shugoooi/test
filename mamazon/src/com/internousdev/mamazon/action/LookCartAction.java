package com.internousdev.mamazon.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.internousdev.mamazon.dto.UserDTO;
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
	 * カート中身の商品情報及び購入予定個数のリスト
	 */
	private ArrayList<CartInfoDTO> cartList = new ArrayList<>();

	/**
	 * カート内商品の合計金額
	 */
	private int totalPrice = 0;


	/**
	 * カートの中身を確認する
	 */
	public String execute() {

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		GoodsDAO goodsDAO = new GoodsDAO();

		//ログインしているならカート情報をさらに取得
		if( session.containsKey("userInfo") ) {
			if( ((UserDTO) session.get("userInfo")).getLoginFlg() ) {

				cartInfoDAO.getCartInfo( (int)session.get("masterId"), cartList );
				//カート情報に商品の値段、在庫情報を追加
				for(CartInfoDTO dto : cartList) {
					GoodsDTO goodsDTO = goodsDAO.getGoodsInfo( dto.getGoodsName() );
					dto.setGoodsInfo(goodsDTO);
				}

			}
		}

		if(! session.containsKey("cartInfo") ) {
			session.put("cartInfo",  cartList);
		}

		for(CartInfoDTO dto : cartList) {
			totalPrice += dto.totalGoodsPrice();
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
	 * @param cartList セットする cartList
	 */
	public void setCartList(ArrayList<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * 購入額の総計を取得
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}
}
