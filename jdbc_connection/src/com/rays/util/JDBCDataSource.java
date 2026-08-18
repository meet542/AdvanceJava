package com.rays.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

// DCP - Data Connection Pool

public class JDBCDataSource {

	public static Connection getConnection() {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

}
