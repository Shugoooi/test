package com.internousdev.yataberyouhin.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yataberyouhin.dao.CartInfoDAO;
import com.internousdev.yataberyouhin.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PutProductIntoCartAction extends ActionSupport implements SessionAware {

	Map<String, Object> session;

	int productId;

	public String execute() throws SQLException {
		String result = ERROR;

		CartInfoDAO dao = new CartInfoDAO();
		CartInfoDTO dto = new CartInfoDTO();
		dto.setUserId(session.get("userId").toString());
		dto.setProductId(productId);

		if(dao.putProductIntoCart(dto)) {
			result = SUCCESS;
		}

		return result;
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

	/**
	 * @return productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId セットする product_id
	 */
	public void setProduct_id(int productId) {
		this.productId = productId;
	}
}
