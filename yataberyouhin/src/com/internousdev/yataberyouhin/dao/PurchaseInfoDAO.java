package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.yataberyouhin.dto.CartInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class PurchaseInfoDAO {
	DBConnector db=new DBConnector();
	Connection con=null;




	public boolean putPurchaseInfo(CartInfoDTO dto) throws SQLException{
		boolean result=false;

		String sql="insert into purchase_history_info(user_id,product_id,insert_date) values(?,?,now())";
		try{
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getUserId());
			ps.setInt(2, dto.getProductId());

			result=ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;

	}

}
