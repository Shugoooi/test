package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品の詳細を見る
 * @author internousdev
 *
 */
public class ShowGoodsDetailAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session = new HashMap<>();

	private String goodsName;

	private GoodsDTO dto = new GoodsDTO();


	/**
	 * 商品の詳細を見る
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		GoodsDAO dao = new GoodsDAO();
		dto = dao.getGoodsInfo(goodsName);
		session.put("targetGoods",  goodsName);
		return SUCCESS;
	}


	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	/**
	 * @param goodsName セットする goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	/**
	 * @return dto
	 */
	public GoodsDTO getDto() {
		return dto;
	}
}
