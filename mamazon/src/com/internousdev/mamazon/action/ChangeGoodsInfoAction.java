package com.internousdev.mamazon.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeGoodsInfoAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 変更後の商品名
	 */
	private String oldGoodsName;

	/**
	 * 変更前の商品名
	 */
	private String goodsName;

	/**
	 * 変更前の画像ファイルの名前
	 */
	private String oldFileName;

	/**
	 * 変更後の画像ファイルの名前
	 */
	private String fileName;

	/**
	 * 画像ファイル
	 */
	private File file = new File(new String());

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
	 * 入力エラーメッセージ（商品情報の入力漏れがあったときに表示）
	 */
	private String inputErr;

	/**
	 * 商品名エラーメッセージ
	 */
	private String goodsNameErr;


	/**
	 * HTTPリクエスト
	 */
	HttpServletRequest request;

	public String execute() throws SQLException {
		//商品情報の入力チェック
		if (goodsName.isEmpty() || category.isEmpty() || price==0 ) {
			inputErr = "入力漏れがありませんか？";
			return ERROR;
		}

		//商品名が有効かチェック
		if (! goodsName.equals(oldGoodsName)) {
			GoodsDAO confirmGoodsName = new GoodsDAO();
			if(confirmGoodsName.isAlreadyUsed(goodsName)) {
				goodsNameErr = "その商品名は既に使われています";
				return ERROR;
			}
		}

		//画像ファイルを読み込んでいたら画像保管庫へ保存
		if(file.exists()){
			fileName = oldGoodsName + ".jpg";
			fileDir = new File(request.getServletContext().getRealPath("/img"));
			File outputFile = new File(fileDir, fileName);
			BufferedImage readImage = null;

			try {
				readImage = ImageIO.read(file);
				ImageIO.write(readImage, "jpg", outputFile);

			} catch (Exception e) {
				e.printStackTrace();
				readImage = null;
			}
		}

		//画像ファイル名を変更する
		fileName = goodsName + ".jpg";
		oldFileName = oldGoodsName + ".jpg";
		fileDir = new File(request.getServletContext().getRealPath("/img"));
		File oldFile = new File(fileDir, oldFileName);
		File newFile = new File(fileDir, fileName);
		oldFile.renameTo(newFile);

		//商品情報の変更をDBへ登録する
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = new GoodsDTO(goodsName, "img/"+fileName, category, price, stock);
		dao.changeGoodsInfo(dto, oldGoodsName);


		return SUCCESS;
	}


	/**
	 * @return oldGoodsName
	 */
	public String getOldGoodsName() {
		return oldGoodsName;
	}


	/**
	 * @return newGoodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}


	/**
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @return file
	 */
	public File getFile() {
		return file;
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
	 * @param oldGoodsName セットする oldGoodsName
	 */
	public void setOldGoodsName(String oldGoodsName) {
		this.oldGoodsName = oldGoodsName;
	}


	/**
	 * @param goodsName セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	/**
	 * @param fileName セットする fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	@Override
	/**
	 * @param request セットする request
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
