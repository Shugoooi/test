package com.internousdev.yataberyouhin.action;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yataberyouhin.dao.ProductListDAO;
import com.internousdev.yataberyouhin.dto.ProductListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {

	private ArrayList<ProductListDTO> productListDTO = new ArrayList<ProductListDTO>();
	private Map<String, Object> session;

	public String execute() {
		String ret = ERROR;

		ProductListDAO dao = new ProductListDAO();
		productListDTO=dao.selectAll();


		if (productListDTO.size() > 0) {
			session.put("productListDTO", productListDTO);

			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

	public ArrayList<ProductListDTO> getProductDTOList() {
		return productListDTO;
	}

	public void setProductDTOList(ArrayList<ProductListDTO> productDTOList) {
		this.productListDTO = productDTOList;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
