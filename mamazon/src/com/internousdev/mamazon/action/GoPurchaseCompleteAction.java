package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dao.PurchaseDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 購入完了する
 * @author internousdev
 *
 */
public class GoPurchaseCompleteAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 購入完了する
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		CartInfoDAO dao = new CartInfoDAO();
		GoodsDAO goodsDAO = new GoodsDAO();
		ArrayList<CartInfoDTO> cartList = new ArrayList<>();
		for(CartInfoDTO dto : dao.getCartTMP()) {
			//カートの商品情報を取得
			GoodsDTO goodsDTO = goodsDAO.getGoodsInfo(dto.getGoodsName());
			dto.setGoodsInfo(goodsDTO);
			dto.setOwner(session.get("userId").toString());

			//購入分在庫を減らす
			goodsDAO.updateStock(dto);

			cartList.add(dto);
		}

		//購入履歴を追加
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		purchaseDAO.setPurchaseHistories(cartList);

		//購入したカート情報の消去
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartInfoDAO.delCartInfo(session.get("userId").toString());
		cartInfoDAO.delCartTMP();
		return SUCCESS;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
