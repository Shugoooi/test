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
				userDTO.setUserInfo( rs.getString("id"),
									rs.getString("pass"),
									rs.getString("name"),
									rs.getInt("tel"),
									rs.getString("mail"),
									rs.getString("address"));
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
	 * 与えられたユーザー情報をDBに登録
	 * @param userDTO
	 * @throws SQLException
	 */
	public void setUserInfo(UserDTO userDTO) throws SQLException{

		String sql = "INSERT INTO user_info(name, id, pass, tel, mail, address, create_date, update_date) VALUES(?, ?, ?, ?, ?, ?, NOW(), NOW());";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserName());
			ps.setString(2,  userDTO.getId());
			ps.setString(3, userDTO.getPassword());
			ps.setInt(4,  userDTO.getTel());
			ps.setString(5, userDTO.getMail());
			ps.setString(6,  userDTO.getAddress());
			ps.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	/**
	 * 与えられたユーザー情報をDBに登録
	 * @param userDTO
	 * @throws SQLException
	 */
	public void updateUserInfo(UserDTO userDTO) throws SQLException{

		String sql = "UPDATE user_info SET name=?, pass=?, tel=?, mail=?, address=?, update_date=NOW() where id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserName());
			ps.setString(6,  userDTO.getId());
			ps.setString(2, userDTO.getPassword());
			ps.setInt(3,  userDTO.getTel());
			ps.setString(4, userDTO.getMail());
			ps.setString(5,  userDTO.getAddress());
			ps.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	/**
	 * 目標のIDが既に使われていたらfalseを返す（紛らわしい）
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean idChk(String id) throws SQLException {
		String sql = "SELECT * from user_info where id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return false;
			} else {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return false;
	}
}
