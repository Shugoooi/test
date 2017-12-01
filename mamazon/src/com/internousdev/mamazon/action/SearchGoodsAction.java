package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchGoodsAction extends ActionSupport {

	/**
	 * 検索キーワード
	 */
	private String keyword = new String();

	/**
	 * 検索カテゴリ
	 */
	private String category = new String();

	/**
	 * 検索に引っかかった商品のリスト
	 */
	private ArrayList<GoodsDTO> goodsList = new ArrayList<>();

	public String execute() throws SQLException {
		GoodsDAO dao = new GoodsDAO();
		if(keyword.isEmpty()){
			if(category.equals("未選択")) {
				return SUCCESS;
			} else {
				for (GoodsDTO dto : dao.collectGoodsMatchedCategory(category)) {
					goodsList.add(dto);
				}

			}
		} else {
			if(category.equals("未選択")) {
				for (GoodsDTO dto : dao.searchGoodsMatchedWords(keyword)) {
					goodsList.add(dto);
				}
			} else {
				for (GoodsDTO dto : dao.searchGoods(keyword, category)) {
					goodsList.add(dto);
				}
			}
		}
		return SUCCESS;
	}

	/**
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param goodsList セットする goodsList
	 */
	public void setGoodsList(ArrayList<GoodsDTO> goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * @return goodsList
	 */
	public ArrayList<GoodsDTO> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param keyword セットする keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @param category セットする category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}
