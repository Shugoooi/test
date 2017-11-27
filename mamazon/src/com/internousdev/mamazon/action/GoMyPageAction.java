package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dao.PurchaseDAO;
import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.internousdev.mamazon.dto.PurchaseDTO;
import com.internousdev.mamazon.dto.UserDTO;
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
	 * 一時カート情報
	 */
	private ArrayList<CartInfoDTO> cartList = new ArrayList<>();

	/**
	 * カートから削除する商品
	 */
	private String deleteGoods = new String();

	/**
	 * ユーザーネーム
	 */
	private String userName;

	/**
	 * ID
	 */
	private String id;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 電話番号
	 */
	private String tel;

	/**
	 * メアド
	 */
	private String mail;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * カート内の合計金額
	 */
	private int totalPrice = 0;

	/**
	 * 購入履歴
	 */
	private ArrayList<PurchaseDTO> purchaseHistories = new ArrayList<>();


	/**
	 * マイページへ飛ぶ
	 * @return
	 * @throws SQLException
	 */
	public String execute() throws SQLException {



		//マイカード表示モード
		if(myPageDisplay.equals("myCart")) {

			//カート内の指定した商品(deleteGoods)があれば削除する
			if(!deleteGoods.isEmpty()) {
				CartInfoDAO cartInfoDAO = new CartInfoDAO();
				CartInfoDAO cartInfoDAO2 = new CartInfoDAO();
				cartInfoDAO.delGoodsFromCartInfo(deleteGoods, session.get("userId").toString());
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
		}

		//購入履歴表示モード
		else if(myPageDisplay.equals("myPurchaseHistory")) {

			//ログインユーザーの購入履歴をリストで拾ってくる
			PurchaseDAO purchaseDAO = new PurchaseDAO();
			for(PurchaseDTO purchaseDTO : purchaseDAO.getPurchaseHistories(session.get("userId").toString()) ) {
				purchaseHistories.add(purchaseDTO);
			}
		}

		//ユーザー情報表示モード
		else {

			//ログインユーザーの情報を拾ってきて変数に格納する
			UserDAO dao = new UserDAO();
			UserDTO dto = dao.getUserInfo(session.get("userId").toString());
			userName = dto.getUserName();
			id = dto.getId();
			password = dto.getPassword();
			tel = dto.getTel();
			mail = dto.getMail();
			address = dto.getAddress();
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
	 * @return cartList
	 */
	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	/**
	 * @param deleteGoods セットする deleteGoods
	 */
	public void setDeleteGoods(String deleteGoods) {
		this.deleteGoods = deleteGoods;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @return purchaseHistories
	 */
	public ArrayList<PurchaseDTO> getPurchaseHistories() {
		return purchaseHistories;
	}
}
