package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.yataberyouhin.dto.MyPageDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class MyPage2DAO {
	private DBConnector db=new DBConnector();

	public ArrayList<MyPageDTO> getMyPageUserIn(String user_id){
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
	    Connection con=db.getConnection();

		String sql="select * from purchase_history_info left join product info where user_id=? ";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,user_id);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setUserName(rs.getString("product_name"));
				dto.setUserNameKana(rs.getString("product_name_kana"));
				dto.setCount(rs.getString("price"));
				dto.setImage(rs.getString("image_file_path"));
				dto.setId(rs.getString("release_date"));
				dto.setCompany(rs.getString("release_company"));
				myPageDTO.add(dto);

			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return myPageDTO;

	}


}
