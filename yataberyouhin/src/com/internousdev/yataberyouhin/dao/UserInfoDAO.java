package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.yataberyouhin.dto.UserInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class UserInfoDAO {

	DBConnector db = new DBConnector();
	Connection con = null;

	public boolean registerUser(UserInfoDTO dto) throws SQLException {
		boolean result = false;

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, register_date) "
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getUserId());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getFamilyName());
		ps.setString(4, dto.getFirstName());
		ps.setString(5, dto.getFamilyNameKana());
		ps.setString(6, dto.getFirstNameKana());
		ps.setBoolean(7, dto.isSex());
		ps.setString(8, dto.getEmail());

		result = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return result;
	}
}
