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

		String sql = "SELECT goods_name, purchase_number, owner FROM cart_info where owner = ?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, owner);
			ResultSet rs = ps.executeQuery();

			while( rs.next() ) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setCartInfo(rs.getString("goods_name"),
								rs.getInt("purchase_number"),
								rs.getString("owner"));
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
	public boolean setCartInfo(CartInfoDTO dto) throws SQLException {

		boolean ret = false;

		String sql = "INSERT INTO cart_info(goods_name, purchase_number, owner) VALUES(?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getGoodsName());
			ps.setInt(2, dto.getPurchaseCount());
			ps.setString(3, dto.getOwner());
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;

	}

	/**
	 * カートの商品の購入予定数を変更する
	 * @param dto
	 * @throws SQLException
	 */
	public boolean updateUserPurchaseCount(CartInfoDTO dto) throws SQLException {

		boolean ret = false;

		String sql = "UPDATE cart_info SET purchase_number=? WHERE owner=? and goods_name=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getPurchaseCount());
			ps.setString(2, dto.getOwner());
			ps.setString(3, dto.getGoodsName());
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}


	/**
	 * 目標のユーザーのカート情報を消去する
	 * @param owner
	 * @throws SQLException
	 */
	public int delCartInfo(String owner) throws SQLException {

		int ret = 0;

		String sql = "DELETE FROM cart_info where owner=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, owner);
			ret = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}

	/**
	 * カート情報を一時的に保存するcart_tmpを作成する
	 */
	public boolean createCartTMP() throws SQLException {

		boolean ret = false;

		String sql = "CREATE TABLE IF not EXISTS cart_tmp(goods_name varchar(255), purchase_number int(8), owner varchar(255))";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}

	/**
	 * 一時カートの情報を取得
	 * @param owner
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CartInfoDTO> getCartTMP() throws SQLException {

		ArrayList<CartInfoDTO> cartInfoList = new ArrayList<>();

		String sql = "SELECT goods_name, purchase_number FROM cart_tmp";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while( rs.next() ) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setCartInfo(rs.getString("goods_name"),
								rs.getInt("purchase_number"));
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
	 * 目標の商品がカートに入っているか確認する
	 * @param goodsName
	 * @return
	 * @throws SQLException
	 */
	public boolean isAlreadyIntoCartInfo(String goodsName, String owner) throws SQLException {

		boolean ret = false;

		String sql = "SELECT goods_name FROM cart_info where goods_name=? and owner=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ps.setString(2, owner);
			ret = ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}

	/**
	 * 目標の商品が一時カートに入っているか確認する
	 * @param goodsName
	 * @return
	 * @throws SQLException
	 */
	public boolean isAlreadyIntoCartTMP(String goodsName) throws SQLException {

		boolean ret = false;

		String sql = "SELECT goods_name FROM cart_tmp where goods_name=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ret = ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}

	/**
	 * 商品を一時カートへ入れる
	 */
	public boolean setCartTMP(CartInfoDTO dto) throws SQLException {

		boolean ret = false;

		String sql = "INSERT INTO cart_tmp(goods_name, purchase_number, owner) VALUES(?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getGoodsName());
			ps.setInt(2, dto.getPurchaseCount());
			ps.setString(3, dto.getOwner());
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;

	}

	/**
	 * 一時カートの商品の購入予定数を変更する
	 * @param dto
	 * @throws SQLException
	 */
	public boolean updateTMPPurchaseCount(CartInfoDTO dto) throws SQLException {

		boolean ret = false;

		String sql = "UPDATE cart_tmp SET purchase_number=? WHERE goods_name=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getPurchaseCount());
			ps.setString(2, dto.getGoodsName());
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}

	/**
	 * 一時カートを削除する
	 */
	public boolean delCartTMP() throws SQLException {

		boolean ret = false;

		String sql = "DROP TABLE IF exists cart_tmp";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}


	/**
	 * 商品をログイン者のカートから外す
	 * @param deleteGoods
	 * @throws SQLException
	 */
	public boolean delGoodsFromCartInfo(String deleteGoods, String owner) throws SQLException {

		boolean ret = false;

		String sql = "DELETE FROM cart_info where goods_name=? and owner=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, deleteGoods);
			ps.setString(2, owner);
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}


	/**
	 * 商品を一時カートから外す
	 * @param deleteGoods
	 * @throws SQLException
	 */
	public boolean delGoodsFromCartTMP(String deleteGoods) throws SQLException {

		boolean ret = false;

		String sql = "DELETE FROM cart_tmp where goods_name=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, deleteGoods);
			ret = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}
}
