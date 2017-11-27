package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品の詳細を見る
 * @author internousdev
 *
 */
public class ShowGoodsDetailAction extends ActionSupport {

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 商品価格
	 */
	private int price;

	/**
	 * 画像
	 */
	private String imgLocated;

	/**
	 * 在庫
	 */
	private int stock;

	/**
	 * 購入予定個数
	 */
	private ArrayList<Integer> purchaseCount = new ArrayList<>();

	/**
	 * 既に商品がカートに入ってるメッセージ
	 */
	private String goodsAlreadyIntoCartMessage = new String();

	/**
	 * 既に商品がカートに入っているかどうか
	 */
	private Boolean goodsAlreadyIntoCartFlg = false;

	/**
	 * 商品の詳細を見る
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		//カートにすでに入っているか確認、入っていたらその旨を伝えて、個数変更をするか聞くようにする
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		if(cartInfoDAO.isAlreadyIntoCartTMP(goodsName)) {
			goodsAlreadyIntoCartMessage = "既に商品がカートに入っています";
			goodsAlreadyIntoCartFlg = true;
		}

		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.getGoodsInfo(goodsName);
		price = dto.getPrice();
		imgLocated = dto.getImgLocated();
		stock = dto.getStock();
		for(int i=1; i <= 10; i++) {
			purchaseCount.add(i);
			if(i == stock)break;
		}
		return SUCCESS;
	}


	/**
	 * @param goodsName セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	/**
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}


	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}


	/**
	 * @return imgLocated
	 */
	public String getImgLocated() {
		return imgLocated;
	}


	/**
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}


	/**
	 * @return purchaseCount
	 */
	public ArrayList<Integer> getPurchaseCount() {
		return purchaseCount;
	}


	/**
	 * @return goodsAlreadyIntoCartMessage
	 */
	public String getGoodsAlreadyIntoCartMessage() {
		return goodsAlreadyIntoCartMessage;
	}


	/**
	 * @return goodsAlreadyIntoCartFlg
	 */
	public Boolean getGoodsAlreadyIntoCartFlg() {
		return goodsAlreadyIntoCartFlg;
	}

}
