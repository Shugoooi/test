package com.internousdev.mamazon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBへ接続をする
 * @author internousdev
 *
 */
public class DBConnector {
	Connection con = null;

	/**
	 * DBへ接続をする
	 */
	public Connection getConnection() {
		final String driverName = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://localhost/mamazon";
		final String user = "root";
		final String password = "mysql";

		try {
			Class.forName(driverName);

			con = DriverManager.getConnection(url, user, password);

		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;
	}
}
