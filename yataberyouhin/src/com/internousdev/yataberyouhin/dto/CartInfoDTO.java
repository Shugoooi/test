package com.internousdev.yataberyouhin.dto;

import java.util.Date;

public class CartInfoDTO {

	private int id;
	private String userId;
	private int productId;
	private Date insertDate;
	private Date updateDate;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}

	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}

	public Date getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(Date insertDate){
		this.insertDate=insertDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate=updateDate;
	}



}
