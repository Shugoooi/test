package com.internousdev.yataberyouhin.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.yataberyouhin.dto.ProductListDTO;
import com.internousdev.yataberyouhin.util.DBConnector;



public class ProductListDAO {
public ArrayList<ProductListDTO> productListDTO=new ArrayList<ProductListDTO>();

public ArrayList<ProductListDTO> selectAll(){
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	String sql="select distinct p.product_id as product_id,"
			  +"p.product_name as product_name,"
			  +"p.product_name_kana as product_name_kana,"
			  +"p.product_description as product_description,"
			  +"m.category_id as category_id,"
			  +"p.price as price"
			  +"p.image_file_path as image_file_path,"
			  +"p.image_file_name as image_file_name,"
			  +"p.release_date datetime as release_date datetime,"
			  +"p.release_company as release_company,"
			  +"p.status as status,"
			  +"p.insert_date as register_date,"
			  +"p.update_date as update_date,"
			  +"from product_info as p,"
			  +"m.m_category as m,"
			  +"where m.category_id=p.category_id;";


	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			ProductListDTO dto = new ProductListDTO();
			dto.setId(rs.getInt("id"));
			dto.setProductName(rs.getString("product_name"));
			dto.setProductNameKana(rs.getString("product_name_kana"));
			dto.setProductDescription(rs.getString("product_description"));
			dto.setCategoryId(rs.getInt("category_id"));
			dto.setPrice(rs.getInt("price"));
			dto.setImageFilePath(rs.getString("image_file_path"));
			dto.setImageFileName(rs.getString("image_file_name"));
			dto.setReleaseDate(rs.getDate("release_date"));
			dto.setReleaseCompany(rs.getString("release_company"));
			dto.setStatus(rs.getShort("status"));
			dto.setInsertDate(rs.getDate("insert_date"));
			dto.setUpdateDate(rs.getDate("update_date"));
			productListDTO.add(dto);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return productListDTO;
}
}
