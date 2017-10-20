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
	 */
	public UserDTO getUserInfo(String loginId, String loginPassword) {

		UserDTO userDTO = new UserDTO();

		String sql = "SELECT id, pass, name FROM user_info where id=? AND pass=?;";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2,  loginPassword);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				userDTO.setUserInfo( rs.getString("id"),
								rs.getString("pass"),
								rs.getString("name"));
				userDTO.setLoginFlg(true);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return userDTO;
	}

	/**
	 * 与えられたユーザー情報をDBに登録
	 * @param userDTO
	 */
	public void setUserInfo(UserDTO userDTO){

		String sql = "INSERT INTO user_info(name, id, pass, tel, mail, address) VALUES(?, ?, ?, ?, ?, ?);";

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
		}
	}

}
