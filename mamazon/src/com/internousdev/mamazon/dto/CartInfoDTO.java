package com.internousdev.mamazon.dto;


/**
 * カート情報を取得及びセットする
 * @author internousdev
 *
 */
public class CartInfoDTO extends GoodsDTO {
	/**
	 * １つのカート情報のID
	 */
	private int owner;

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 購入予定の数
	 */
	private int buyCount;

	/**
	 * 商品名の取得
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * カート情報の取得
	 * @param goodsName
	 * @param buyCount
	 */
	public void setCartInfo(String goodsName, int buyCount) {
		this.goodsName = goodsName;
		this.buyCount = buyCount;
	}

	/**
	 * この商品の購入金額
	 * @return
	 */
	public int totalGoodsPrice() {
		return price * buyCount;
	}

}
