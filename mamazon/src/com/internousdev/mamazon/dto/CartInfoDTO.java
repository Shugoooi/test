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
	private String owner;

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 購入予定の数
	 */
	private int purchaseCount;

	/**
	 * @param owner セットする owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * 商品名の取得
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @return purchaseCount
	 */
	public int getPurchaseCount() {
		return purchaseCount;
	}

	/**
	 * カート情報の取得
	 * @param goodsName
	 * @param purchaseCount
	 * @param owner
	 */
	public void setCartInfo(String goodsName, int purchaseCount, String owner) {
		this.goodsName = goodsName;
		this.purchaseCount = purchaseCount;
		this.owner = owner;
	}

	/**
	 * カート情報の取得
	 * @param goodsName
	 * @param purchaseCount
	 */
	public void setCartInfo(String goodsName, int purchaseCount) {
		this.goodsName = goodsName;
		this.purchaseCount = purchaseCount;
	}

	/**
	 * この商品の購入金額
	 * @return
	 */
	public int totalGoodsPrice() {
		return price * purchaseCount;
	}

}
