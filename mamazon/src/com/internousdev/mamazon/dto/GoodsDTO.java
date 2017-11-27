package com.internousdev.mamazon.dto;

public class GoodsDTO {

	/**
	 * 商品名
	 */
	private String name;


	/**
	 * 画像の置き場所
	 */
	private String imgLocated;

	/**
	 * カテゴリ名
	 */
	private String category;

	/**
	 * 商品の値段
	 */
	protected int price;

	/**
	 * 商品の在庫
	 */
	protected int stock;

	public GoodsDTO(){}

	public GoodsDTO(String name, String imgLocated, String category, int price, int stock) {
		this.name = name;
		this.imgLocated = imgLocated;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}


	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return imgLocated
	 */
	public String getImgLocated() {
		return imgLocated;
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}


	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 商品情報の取得
	 * @param name
	 * @param imgLocated
	 * @param price
	 * @param stock
	 */
	public void setGoodsInfo(String name, String imgLocated, int price, int stock) {
		this.name = name;
		this.imgLocated = imgLocated;
		this.price = price;
		this.stock = stock;
	}

	/**
	 * カートに含まれている商品の情報を取得
	 * @param dto
	 */
	public void setGoodsInfo(GoodsDTO dto) {
		this.name = dto.name;
		this.imgLocated = dto.imgLocated;
		this.price = dto.price;
		this.stock = dto.stock;
	}

}
