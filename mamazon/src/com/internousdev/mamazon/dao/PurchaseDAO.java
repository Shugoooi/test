package com.internousdev.mamazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dto.PurchaseDTO;
import com.internousdev.mamazon.util.DBConnector;

/**
 * DB接続して購入履歴をいじくる？
 * @author internousdev
 *
 */
public class PurchaseDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 	購入履歴をPurchaseDTOリストで返す
	 * @throws SQLException
	 */
	public ArrayList<PurchaseDTO> getPurchaseHistories(String userName) throws SQLException {

		ArrayList<PurchaseDTO> purchaseHistories = new ArrayList<PurchaseDTO>();

		PurchaseDTO dto = new PurchaseDTO();

		String sql = "SELECT goods_name, goods_price, purchase_count FROM purchase_history where purchaser=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				dto.setPurchaseHistory(rs.getString("goods_name"),
										rs.getInt("goods_price"),
										rs.getInt("purchase_count"));
				purchaseHistories.add(dto);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return purchaseHistories;
	}
}
