package com.internousdev.mamazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.mamazon.dto.CartInfoDTO;
import com.internousdev.mamazon.dto.GoodsDTO;
import com.internousdev.mamazon.util.DBConnector;

public class GoodsDAO {
	DBConnector db = new DBConnector();
	Connection con = null;


	/**
	 * 商品名から商品情報を取得
	 * @param goodsName
	 * @return
	 * @throws SQLException
	 */
	public GoodsDTO getGoodsInfo(String goodsName) throws SQLException {

		GoodsDTO dto = new GoodsDTO();
		con = db.getConnection();

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
		} finally {
			con.close();
		}

		return dto;
	}

	/**
	 * カテゴリに当てはまる商品のリストを取得する
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<GoodsDTO> collectGoodsMatchedCategory(String category) throws SQLException {

		ArrayList<GoodsDTO> goodsList = new ArrayList<>();
		con = db.getConnection();

		String sql = "SELECT name, img_located, price, stock FROM goods_info where category=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			while( rs.next() ) {
				GoodsDTO dto = new GoodsDTO();
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


	/**
	 * キーワードから商品を検索する
	 * @param keyword
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<GoodsDTO> searchGoodsMatchedWords(String keyword) throws SQLException {

		ArrayList<GoodsDTO> goodsList = new ArrayList<>();
		con = db.getConnection();

		String sql = "SELECT name, img_located, price, stock FROM goods_info where name LIKE \'%" + keyword + "%\'";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while( rs.next() ) {
				GoodsDTO dto = new GoodsDTO();
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

	/**
	 * キーワードとカテゴリ名から商品を検索する
	 * @param keyword
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<GoodsDTO> searchGoods(String keyword, String category) throws SQLException {

		ArrayList<GoodsDTO> goodsList = new ArrayList<>();
		con = db.getConnection();

		String sql = "SELECT name, img_located, price, stock FROM goods_info where category=? AND name LIKE \'%" + keyword + "%\'";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			while( rs.next() ) {
				GoodsDTO dto = new GoodsDTO();
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

	/**
	 * 商品の購入に伴って在庫を変更する
	 * @param dto
	 * @throws SQLException
	 */
	public boolean updateStock(CartInfoDTO dto) throws SQLException {

		int updateCount = 0;
		boolean result = false;
		con = db.getConnection();

		String sql = "UPDATE goods_info SET stock=? WHERE name=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getStock()-dto.getPurchaseCount());
			ps.setString(2, dto.getGoodsName());
			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		if(updateCount == 1) {
			result = true;
		}

		return result;
	}

	/**
	 * 商品名が既に使われているか確認
	 * @param goodsName
	 * @return
	 * @throws SQLException
	 */
	public boolean isAlreadyUsed(String goodsName) throws SQLException {

		int updateCount = 0;
		boolean result = false;
		con = db.getConnection();

		String sql = "SELECT * FROM goods_info where name=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goodsName);
			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		if(updateCount == 1) {
			result = true;
		}

		return result;
	}

	/**
	 * 新規商品の登録をする
	 * @param dto
	 * @throws SQLException
	 */
	public boolean newGoods(GoodsDTO dto) throws SQLException {

		int updateCount = 0;
		boolean result = false;
		con = db.getConnection();

		String sql = "INSERT INTO goods_info(name, img_located, category, price, stock, create_date) VALUES(?,?,?,?,?,NOW())";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getImgLocated());
			ps.setString(3, dto.getCategory());
			ps.setInt(4, dto.getPrice());
			ps.setInt(5, dto.getStock());
			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		if(updateCount == 1) {
			result = true;
		}

		return result;
	}

	/**
	 * 商品情報を変更する
	 * @param dto
	 * @param oldGoodsName
	 * @throws SQLException
	 */
	public boolean changeGoodsInfo(GoodsDTO dto, String oldGoodsName) throws SQLException {

		int updateCount = 0;
		boolean result = false;
		con = db.getConnection();

		String sql = "UPDATE goods_info SET name=?, img_located=?, category=?, price=?, stock=?, update_time=NOW() WHERE name=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getImgLocated());
			ps.setString(3, dto.getCategory());
			ps.setInt(4, dto.getPrice());
			ps.setInt(5, dto.getStock());
			ps.setString(6, oldGoodsName);
			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		if(updateCount == 1) {
			result = true;
		}

		return result;
	}

}