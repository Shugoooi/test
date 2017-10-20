package com.internousdev.mamazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dto.GoodsDTO;
import com.internousdev.mamazon.util.DBConnector;

public class GoodsDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	GoodsDTO dto = new GoodsDTO();

	/**
	 * 商品名とカテゴリから商品情報を取得
	 * @param goodsName
	 * @param category
	 * @return
	 */
	public GoodsDTO getGoodsInfo(String goodsName) {

		String sql = "SELECT name, img_located, price, stock FROM goods_info where name=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rs = ps.executeQuery();

			if( rs.next() ) {
				dto.setGoodsInfo(rs.getString("name"),
								rs.getString("img_located"),
								rs.getInt("price"),
								rs.getInt("stock"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	/**
	 * カテゴリに当てはまる商品のリストを取得する
	 * @param category
	 * @return
	 */
	public ArrayList<GoodsDTO> collectGoodsMatchedCategory(String category) {

		ArrayList<GoodsDTO> goodsList = new ArrayList<>();

		String sql = "SELECT name, img_located, price, stock FROM goods_info where category=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			if( rs.next() ) {
				dto.setGoodsInfo(rs.getString("name"),
								rs.getString("img_located"),
								rs.getInt("price"),
								rs.getInt("stock"));
				goodsList.add(dto);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return goodsList;
	}

	public ArrayList<GoodsDTO> searchGoodsMatchedWords(String keyword) throws SQLException {
		ArrayList<GoodsDTO> goodsList = new ArrayList<>();

		String sql = "SELECT name, img_located, price, stock FROM goods_info where name LIKE '%s%'";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if( rs.next() ) {
				dto.setGoodsInfo(rs.getString("name"),
								rs.getString("img_located"),
								rs.getInt("price"),
								rs.getInt("stock"));
				goodsList.add(dto);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return goodsList;
	}

}