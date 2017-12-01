package com.internousdev.mamazon.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoChangeGoodsInfoAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 画像ファイル名
	 */
	private String fileName;

	/**
	 * 画像ファイルのパス
	 */
	private String fileDir;

	/**
	 * カテゴリ名
	 */
	private String category;

	/**
	 * 価格
	 */
	private int price;

	/**
	 * 在庫
	 */
	private int stock;

	/**
	 * httpリクエスト
	 */
	private HttpServletRequest request;


	public String execute() throws SQLException {
		//既存商品の情報を取得
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.getGoodsInfo(goodsName);

		//商品の各情報を格納
		String imgLocated[] = dto.getImgLocated().split("/");
		fileName = imgLocated[1];
		fileDir = request.getServletContext().getRealPath("/img") + fileName;
		category = dto.getCategory();
		price = dto.getPrice();
		stock = dto.getStock();

		return SUCCESS;
	}


	/**
	 * @param fileName セットする fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @param fileDir セットする fileDir
	 */
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}


	/**
	 * @param category セットする category
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}


	/**
	 * @param stock セットする stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}


	/**
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}


	/**
	 * @param goodsName セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	/**
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @return fileDir
	 */
	public String getFileDir() {
		return fileDir;
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


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

}
