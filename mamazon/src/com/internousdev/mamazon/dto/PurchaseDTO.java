package com.internousdev.mamazon.dto;

public class PurchaseDTO {

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 商品価格
	 */
	private int goodsPrice;

	/**
	 * 購入数
	 */
	private int purchaseCount;

	/**
	 * 商品名の取得
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 商品価格の取得
	 * @return goodsPrice
	 */
	public int getGoodsPrice() {
		return goodsPrice;
	}

	/**
	 * 購入数の取得
	 * @return purchaseCount
	 */
	public int getPurchaseCount() {
		return purchaseCount;
	}

	/**
	 * 商品名、商品価格、購入数の順にセット
	 * @param goodsName
	 * @param goodsPrice
	 * @param purchaseCount
	 */
	public void setPurchaseHistory(String goodsName, int goodsPrice, int purchaseCount) {
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.purchaseCount = purchaseCount;
	}
}
