package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 目的の商品をカートに入れる
 * @author internousdev
 *
 */
public class SelectGoodsIntoCartAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * カートに入れる商品
	 */
	private String targetGoods;

	/**
	 * 購入予定数
	 */
	private int purchaseCount;

	/**
	 * 商品がカートに既に入っているかどうか
	 */
	private Boolean goodsAlreadyIntoCartFlg;

	public String execute() throws SQLException {
		//カートに入れる商品の情報を取得
		CartInfoDTO cartInfoDTO = new CartInfoDTO();
		cartInfoDTO.setCartInfo(targetGoods, purchaseCount);
		GoodsDAO goodsDAO = new GoodsDAO();
		GoodsDTO goodsDTO = goodsDAO.getGoodsInfo(targetGoods);
		cartInfoDTO.setGoodsInfo(goodsDTO);

		//ログインしているなら購入予定者情報を付加してユーザーのカートに保存
		if(session.containsKey("loginFlg")){
			if( (boolean) session.get("loginFlg") ) {
				CartInfoDAO dao = new CartInfoDAO();
				cartInfoDTO.setOwner(session.get("userId").toString());
				CartInfoDAO dao2 = new CartInfoDAO();
				if(dao2.isAlreadyIntoCartInfo(targetGoods, session.get("userId").toString())) {
					dao.updateUserPurchaseCount(cartInfoDTO);
				} else {
					dao.setCartInfo(cartInfoDTO);
				}
			}
		}

		//目的の商品を一時カートへ入れる
		CartInfoDAO dao2 = new CartInfoDAO();
		dao2.createCartTMP();
		CartInfoDAO dao3 = new CartInfoDAO();
		if(goodsAlreadyIntoCartFlg) {
			dao3.updateTMPPurchaseCount(cartInfoDTO);
		} else {
			dao3.setCartTMP(cartInfoDTO);
		}


		return SUCCESS;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @return targetGoods
	 */
	public String getTargetGoods() {
		return targetGoods;
	}

	/**
	 * @return purchaseCount
	 */
	public int getPurchaseCount() {
		return purchaseCount;
	}

	/**
	 * @return goodsAlreadyIntoCartFlg
	 */
	public Boolean getGoodsAlreadyIntoCartFlg() {
		return goodsAlreadyIntoCartFlg;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @param targetGoods セットする targetGoods
	 */
	public void setTargetGoods(String targetGoods) {
		this.targetGoods = targetGoods;
	}

	/**
	 * @param purchaseCount セットする purchaseCount
	 */
	public void setPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	/**
	 * @param goodsAlreadyIntoCartFlg セットする goodsAlreadyIntoCartFlg
	 */
	public void setGoodsAlreadyIntoCartFlg(Boolean goodsAlreadyIntoCartFlg) {
		this.goodsAlreadyIntoCartFlg = goodsAlreadyIntoCartFlg;
	}
}
