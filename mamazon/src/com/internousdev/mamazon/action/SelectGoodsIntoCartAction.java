package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.internousdev.mamazon.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 目的の商品をカートに入れる
 * @author internousdev
 *
 */
public class SelectGoodsIntoCartAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session = new HashMap<>();

	private int buyCount;

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {
		//カートに入れる商品の情報を取得
		CartInfoDTO cartInfoDTO = new CartInfoDTO();
		cartInfoDTO.setCartInfo(session.get("targetGoods").toString(), buyCount);
		GoodsDAO goodsDAO = new GoodsDAO();
		GoodsDTO dto = goodsDAO.getGoodsInfo(session.get("targetGoods").toString());
		cartInfoDTO.setGoodsInfo(dto);

		//ログインしているなら購入予定者情報を付加してDBに保存
		if(session.containsKey("userInfo")) {
			if( ( (UserDTO) session.get("userInfo") ).getLoginFlg() ) {
				cartInfoDTO.setOwner(( (UserDTO) session.get("userInfo") ).getUserName());
				CartInfoDAO dao = new CartInfoDAO();
				dao.setCartInfo(cartInfoDTO);
			}
		}

		//カート情報がなければ新規に作り、目的の商品をカートへ入れる
		if(session.containsKey("cartInfo")) {
			( (ArrayList<CartInfoDTO>) session.get("cartInfo") ).add(cartInfoDTO);
		} else {
			ArrayList<CartInfoDTO> cartList = new ArrayList<>();
			cartList.add(cartInfoDTO);
			session.put("cartInfo", cartList);
		}

		return SUCCESS;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @param buyCount セットする buyCount
	 */
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
}
