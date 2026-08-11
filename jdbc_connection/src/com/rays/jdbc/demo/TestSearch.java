package com.rays.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root@789");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from st_user");

		while (rs.next()) {
			System.out.print(rs.getInt("id"));
			System.out.print("\t" + rs.getString("firstName"));
			System.out.print("\t" + rs.getString("lastName"));
			System.out.print("\t" + rs.getString("loginId"));
			System.out.print("\t" + rs.getString("password"));
			System.out.println("\t" + rs.getDate("dob"));
		}

	}
}