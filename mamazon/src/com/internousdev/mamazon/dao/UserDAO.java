package com.internousdev.mamazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.mamazon.dto.UserDTO;
import com.internousdev.mamazon.util.DBConnector;


/**
 * ユーザ情報をDBから取得
 * @author internousdev
 *
 */
public class UserDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();


	/**
	 * ユーザー情報をDBから検索
	 * @param loginId
	 * @param loginPassword
	 * @return
	 * @throws SQLException
	 */
	public UserDTO getUserInfo(String loginId, String loginPassword) throws SQLException {

		UserDTO userDTO = new UserDTO();
		String sql = "SELECT id, pass, name, tel, mail, address FROM user_info where id=? AND pass=?;";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2,  loginPassword);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				userDTO.setUserInfo( rs.getString("name"),
									 rs.getString("id"),
									 rs.getString("pass"),
									 rs.getString("tel"),
									 rs.getString("mail"),
									 rs.getString("address")
									 );
				userDTO.setLoginFlg(true);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return userDTO;
	}

	/**
	 * ユーザー情報をDBから検索
	 * @param loginId
	 * @return
	 * @throws SQLException
	 */
	public UserDTO getUserInfo(String loginId) throws SQLException {

		UserDTO userDTO = new UserDTO();
		String sql = "SELECT id, pass, name, tel, mail, address FROM user_info where id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				userDTO.setUserInfo( rs.getString("name"),
									 rs.getString("id"),
									 rs.getString("pass"),
									 rs.getString("tel"),
									 rs.getString("mail"),
									 rs.getString("address")
									 );
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return userDTO;
	}


	/**
	 * 与えられたユーザー情報をDBに登録
	 * @param userDTO
	 * @throws SQLException
	 */
	public boolean setUserInfo(UserDTO userDTO) throws SQLException{

		boolean ret = false;
		String sql = "INSERT INTO user_info(name, id, pass, tel, mail, address, create_date, update_date) VALUES(?, ?, ?, ?, ?, ?, NOW(), NOW());";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserName());
			ps.setString(2,  userDTO.getId());
			ps.setString(3, userDTO.getPassword());
			ps.setString(4,  userDTO.getTel());
			ps.setString(5, userDTO.getMail());
			ps.setString(6,  userDTO.getAddress());
			ret = ps.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}


	/**
	 * 与えられたユーザー情報をDBに登録(上書き）
	 * @param userDTO
	 * @throws SQLException
	 */
	public boolean updateUserInfo(UserDTO userDTO) throws SQLException{

		boolean ret = false;
		String sql = "UPDATE user_info SET name=?, pass=?, tel=?, mail=?, address=?, update_date=NOW() where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserName());
			ps.setString(6,  userDTO.getId());
			ps.setString(2, userDTO.getPassword());
			ps.setString(3,  userDTO.getTel());
			ps.setString(4, userDTO.getMail());
			ps.setString(5,  userDTO.getAddress());

			ret = ps.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}

	/**
	 * 目標のIDが既に使われていたらfalseを返す（紛らわしい）
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean idChk(String id) throws SQLException {

		boolean ret = true;

		String sql = "SELECT * from user_info where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ret = !ps.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}
}
