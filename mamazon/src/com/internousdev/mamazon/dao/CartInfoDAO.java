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
/**
 * @author internousdev
 *
 */
public class CartInfoDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();


	/**
	 * ユーザーのカート情報を取得
	 * @param owner
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CartInfoDTO> getCartInfo(String owner) throws SQLException {

		ArrayList<CartInfoDTO> cartInfoList = new ArrayList<>();

		String sql = "SELECT goods_name, purchase_count FROM cart_info where owner = ?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, owner);
			ResultSet rs = ps.executeQuery();

			while( rs.next() ) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setCartInfo(rs.getString("goods_name"),
								rs.getInt("purchase_count"));
				cartInfoList.add(dto);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return cartInfoList;

	}

	/**
	 * 目標のユーザーが商品をカートに入れたことを記憶する
	 * @param dto
	 * @throws SQLException
	 */
	public void setCartInfo(CartInfoDTO dto) throws SQLException {

		String sql = "INSERT INTO cart_info(goods_name, purchase_count, owner) VALUES(?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getGoodsName());
			ps.setInt(2, dto.getPurchaseCount());
			ps.setString(3, dto.getOwner());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}


	/**
	 * 目標のユーザーのカート情報を消去する
	 * @param owner
	 * @throws SQLException
	 */
	public void delCartInfo(String owner) throws SQLException {
		String sql = "DELETE FROM cart_info where owner=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, owner);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}


}
