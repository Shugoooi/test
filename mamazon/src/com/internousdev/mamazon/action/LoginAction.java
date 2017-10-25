package com.internousdev.mamazon.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mamazon.dao.CartInfoDAO;
import com.internousdev.mamazon.dao.GoodsDAO;
import com.internousdev.mamazon.dao.PurchaseDAO;
import com.internousdev.mamazon.dao.UserDAO;
import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.internousdev.mamazon.dto.PurchaseDTO;
import com.internousdev.mamazon.dto.UserDTO;
import com.internousdev.mamazon.util.MyErrorConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログインする
 * @author internousdev
 *
 */
public class LoginAction extends ActionSupport implements SessionAware, MyErrorConstants {

	/**
	 * セッション
	 */
	private Map<String, Object> session = new HashMap<>();

	/**
	 * ログインID
	 */
	private String loginId;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/**
	 * ログインエラーメッセージ
	 */
	private String loginError = null;


	/**
	 * ログインする
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		//ログイン情報の取得
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.getUserInfo(loginId, loginPassword);

		//ログインを試みる
		if(dto.getLoginFlg()) {

			//ログイン成功、ユーザー情報とカート情報、及び購入履歴を保存及び追加
			session.put("userInfo", dto);

			//カート情報がすでにあれば（非ログイン時の操作により起こりうる）それも保存しておく
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			if(! session.containsKey("cartInfo")) {
				ArrayList<CartInfoDTO> cartList = new ArrayList<>();
				session.put("cartInfo",  cartList);
			} else {
				for(CartInfoDTO cartInfoDTO : (ArrayList<CartInfoDTO>) session.get("cartInfo")) {
					cartInfoDTO.setOwner( ((UserDTO) session.get("userInfo")).getUserName() );
				}
			}
			for( CartInfoDTO cartInfoDTO : cartInfoDAO.getCartInfo( dto.getId() ) ) {
				GoodsDAO goodsDAO = new GoodsDAO();
				GoodsDTO goodsDTO = goodsDAO.getGoodsInfo(cartInfoDTO.getGoodsName());
				cartInfoDTO.setGoodsInfo(goodsDTO);
				cartInfoDTO.setOwner(((UserDTO) session.get("userInfo")).getUserName());
				((ArrayList<CartInfoDTO>) session.get("cartInfo")).add(cartInfoDTO);
			}


			PurchaseDAO purchaseDAO = new PurchaseDAO();
			ArrayList<PurchaseDTO> purchaseHistories = new ArrayList<>();
			purchaseHistories.addAll(purchaseDAO.getPurchaseHistories( ((UserDTO) session.get("userInfo")).getUserName() ));
			session.put("purchaseHistories", purchaseHistories);

			return SUCCESS;
		} else {

			//ログイン失敗、失敗を伝えながらログインページへ
			loginError = LOGIN_ERROR_MESSAGE;
			return ERROR;
		}
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @param loginId セットする loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @param loginPassword セットする loginPassword
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * ログインエラーメッセージの取得
	 * @return loginError
	 */
	public String getLoginError() {
		return loginError;
	}


}
