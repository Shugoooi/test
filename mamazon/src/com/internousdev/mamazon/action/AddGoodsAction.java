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
import com.internousdev.mamazon.util.MyErrorConstants;
import com.opensymphony.xwork2.ActionSupport;

public class AddGoodsAction extends ActionSupport implements ServletRequestAware, MyErrorConstants {

	/**
	 * 商品名
	 */
	private String goodsName;

	/**
	 * 画像ファイルの名前
	 */
	private String fileName = "";

	/**
	 * 画像ファイル
	 */
	private File goodsImg;

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
	 * エラーメッセージ
	 */
	private String errMsg;


	public String execute() throws SQLException {

		//商品情報の入力チェック
		if(goodsName.isEmpty() || category.isEmpty() || price==0 || !goodsImg.exists()) {
			errMsg = INPUT_ERROR_MESSAGE;
			return ERROR;
		}


		//商品名が有効かチェック
		GoodsDAO confirmGoodsName = new GoodsDAO();
		if(confirmGoodsName.isAlreadyUsed(goodsName)) {
			errMsg = GOODSNAME_ERROR_MESSAGE;
			return ERROR;
		}


		//読み込んだ画像ファイルを画像保管庫へ保存
		fileName = goodsName + ".jpg";
		fileDir = new File(request.getServletContext().getRealPath("/img"));
		File outputFile = new File(fileDir, fileName);
		BufferedImage readImage = null;

		try {
			readImage = ImageIO.read(goodsImg);
			if (!ImageIO.write(readImage, "jpg", outputFile)) {
				errMsg = FILE_SAVE_ERROR_MESSAGE;
				return ERROR;
			}

		} catch (IOException e) {
			e.printStackTrace();
			readImage = null;
		}


		//商品情報をDBへ登録
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = new GoodsDTO(goodsName, "img/"+fileName, category, price, stock);
		if(!dao.newGoods(dto)) {
			errMsg = ADD_GOODS_ERROR_MESSAGE;
			return ERROR;
		}

		return SUCCESS;
	}


	/**
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}


	/**
	 * @return goodsImg
	 */
	public File getGoodsImg() {
		return goodsImg;
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
	 * @param errMsg セットする errmsg
	 */
	public void setGoodsNameErr(String errMsg) {
		this.errMsg = errMsg;
	}


	/**
	 * @param goodsName セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	/**
	 * @param goodsImg セットする goodsImg
	 */
	public void setGoodsImg(File goodsImg) {
		this.goodsImg = goodsImg;
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
	 * @return errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}


	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;

	}

}
