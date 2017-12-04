package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.yataberyouhin.dto.CartInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;


public class CartInfoDAO extends ActionSupport{

	DBConnector db = new DBConnector();
	Connection con = null;

	public boolean putProductIntoCart(CartInfoDTO dto) throws SQLException {
		boolean result = false;

		String sql = "INSERT INTO cart_info(user_id, product_id, insert_date) "
				+ 		"VALUES(?, ?, NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUserId());
			ps.setInt(2, dto.getProductId());

			result = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return result;
	}
}
