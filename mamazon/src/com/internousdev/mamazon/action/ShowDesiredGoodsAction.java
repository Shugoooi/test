package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 要求された種類の商品を表示する
 * @author internousdev
 *
 */
public class ShowDesiredGoodsAction extends ActionSupport {

	/**
	 * 商品の検索方法（カテゴリで探すのか、検索フォームから検索するのか、etc...
	 */
	private String howSearchGoods = null;

	/**
	 * カテゴリ名（商品を探す際に指定されていたら使う）
	 */
	private String category = null;

	/**
	 * 検索ワード
	 */
	private String keyword = null;

	/**
	 * 要求された商品リスト
	 */
	ArrayList<GoodsDTO> goodsList = new ArrayList<>();

	public String execute() throws SQLException {
		GoodsDAO dao = new GoodsDAO();

		//カテゴリで探しているのか、それとも検索フォームから探しているのか
		if(howSearchGoods.equals("category")) {

			goodsList.addAll(dao.collectGoodsMatchedCategory(category));

		} else if(howSearchGoods.equals("searchForm")) {

			if(keyword == null){
				return ERROR;
			} else{
				goodsList.addAll(dao.searchGoodsMatchedWords(keyword));
			}
		}

		return SUCCESS;
	}

	/**
	 * 検索方法の取得
	 * @return howSearchGoods
	 */
	public String getHowSearchGoods() {
		return howSearchGoods;
	}

	/**
	 * @param howSearchGoods セットする howSearchGoods
	 */
	public void setHowSearchGoods(String howSearchGoods) {
		this.howSearchGoods = howSearchGoods;
	}

	/**
	 * カテゴリ名の取得
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category セットする category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 検索ワードの取得
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword セットする keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * 商品リストの取得
	 * @return goodsList
	 */
	public ArrayList<GoodsDTO> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param goodsList セットする goodsList
	 */
	public void setGoodsList(ArrayList<GoodsDTO> goodsList) {
		this.goodsList = goodsList;
	}

}
