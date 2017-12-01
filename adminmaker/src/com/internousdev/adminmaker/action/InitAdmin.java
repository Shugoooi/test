package com.internousdev.adminmaker.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import com.internousdev.adminmaker.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class InitAdmin extends ActionSupport{

	Set<String> tableSet = new TreeSet<>();

	public String execute() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DatabaseMetaData dmd = con.getMetaData();
		String types[] = { "TABLE" };
		try {
			ResultSet rs = dmd.getTables(null, null, "%", types);

			while (rs.next()) {
				tableSet.add(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}



		return SUCCESS;
	}

	/**
	 * @return tableSet
	 */
	public Set<String> getTableSet() {
		return tableSet;
	}

	/**
	 * @param tableSet セットする tableSet
	 */
	public void setTableSet(Set<String> tableSet) {
		this.tableSet = tableSet;
	}



}
