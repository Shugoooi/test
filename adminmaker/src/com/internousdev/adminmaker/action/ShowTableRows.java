package com.internousdev.adminmaker.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import com.internousdev.adminmaker.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class ShowTableRows extends ActionSupport{

	String tableName = "";

	Set<String> columnSet = new TreeSet<>();

	public String execute() throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT * FROM ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tableName);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			String targetColumn = rsmd.getColumnLabel(0);
			while(rs.next()) {
				columnSet.add(rs.getString(targetColumn));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}



		return SUCCESS;
	}

	/**
	 * @return tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName セットする tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return columnSet
	 */
	public Set<String> getColumnSet() {
		return columnSet;
	}

	/**
	 * @param columnSet セットする columnSet
	 */
	public void setColumnSet(Set<String> columnSet) {
		this.columnSet = columnSet;
	}



}
