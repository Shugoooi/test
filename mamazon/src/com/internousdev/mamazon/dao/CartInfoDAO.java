package com.internousdev.mamazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.util.DBConnector;

/**
 * DBからカート情報を取得する
 * @author internousdev
 *
 */
public class CartInfoDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public void getCartInfo(int owner, ArrayList<CartInfoDTO> cartInfoList) {


		String sql = "SELECT goods_name, buy_count FROM cart_info where owner == ?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, owner);
			ResultSet rs = ps.executeQuery();

			if( rs.next() ) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setCartInfo(rs.getString("goods_name"),
								rs.getInt("buy_count"));
				cartInfoList.add(dto);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
