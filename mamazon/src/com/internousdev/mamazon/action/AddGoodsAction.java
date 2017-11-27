package com.internousdev.mamazon.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddGoodsAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 画像ファイルの名前
	 */
	private String fileName = new String();

	/**
	 * 画像ファイル
	 */
	private File file;

	/**
	 * 画像ファイルを置く場所
	 */
	private File fileDir;

	/**
	 * カテゴリ名
	 */
	private String category;

	/**
	 * 価格
	 */
	private int price;

	/**
	 * 在庫数
	 */
	private int stock;

	/**
	 * HTTPリクエスト
	 */
	HttpServletRequest request;

	/**
	 * 入力エラーメッセージ（商品情報の入力漏れがあったときに表示）
	 */
	private String inputErr;

	/**
	 * 商品名エラーメッセージ
	 */
	private String goodsNameErr;

	/**
	 * 画像ファイル作成エラーメッセージ
	 */
	private String fileCreateErr;


	public String execute() throws SQLException {

		//商品情報の入力チェック
		if(goodsName.isEmpty() || category.isEmpty() || price==0 || !file.exists()) {
			inputErr = "入力漏れがありませんか？";
			return ERROR;
		}


		//商品名が有効かチェック
		GoodsDAO confirmGoodsName = new GoodsDAO();
		if(confirmGoodsName.isAlreadyUsed(goodsName)) {
			goodsNameErr = "その商品名は既に使われています";
			return ERROR;
		}


		//読み込んだ画像ファイルを画像保管庫へ保存
		fileName = goodsName + ".jpg";
		fileDir = new File(request.getServletContext().getRealPath("/img"));
		File outputFile = new File(fileDir, fileName);
		BufferedImage readImage = null;

		try {
			readImage = ImageIO.read(file);
			ImageIO.write(readImage, "jpg", outputFile);

		} catch (IOException e) {
			e.printStackTrace();
			readImage = null;
		}


		//商品情報をDBへ登録
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = new GoodsDTO(goodsName, "img/"+fileName, category, price, stock);
		dao.newGoods(dto);


		return SUCCESS;
	}


	/**
	 * @param goodsName セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	/**
	 * @param file セットする file
	 */
	public void setFile(File file) {
		this.file = file;
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
	 * @return inputErr
	 */
	public String getInputErr() {
		return inputErr;
	}


	/**
	 * @return goodsNameErr
	 */
	public String getGoodsNameErr() {
		return goodsNameErr;
	}


	/**
	 * @return fileCreateErr
	 */
	public String getFileCreateErr() {
		return fileCreateErr;
	}


	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;

	}

}
