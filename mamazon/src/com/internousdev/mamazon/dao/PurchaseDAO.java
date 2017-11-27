package com.internousdev.mamazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dto.CartInfoDTO;
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
	 * 購入履歴を追加する
	 * @param cartList
	 * @throws SQLException
	 */
	public void setPurchaseHistories(ArrayList<CartInfoDTO> cartList) throws SQLException {
		String sql = "INSERT INTO purchase_history(purchaser, goods_name, goods_price, purchase_number, purchase_date) VALUES(?, ?, ?, ?, NOW());";

	try{
		for(CartInfoDTO dto : cartList) {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getOwner());
		ps.setString(2, dto.getGoodsName());
		ps.setInt(3, dto.getPrice());
		ps.setInt(4, dto.getPurchaseCount());
		ps.execute();
		}

	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		con.close();
	}
}

	/**
	 * 	購入履歴をPurchaseDTOリストで返す
	 * @throws SQLException
	 */
	public ArrayList<PurchaseDTO> getPurchaseHistories(String userId) throws SQLException {

		ArrayList<PurchaseDTO> purchaseHistories = new ArrayList<PurchaseDTO>();


		String sql = "SELECT goods_name, goods_price, purchase_number FROM purchase_history where purchaser=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				PurchaseDTO dto = new PurchaseDTO();
				dto.setPurchaseHistory(rs.getString("goods_name"),
										rs.getInt("goods_price"),
										rs.getInt("purchase_number"));
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
