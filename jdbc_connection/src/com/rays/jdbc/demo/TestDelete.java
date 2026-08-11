package com.rays.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root@789");

		Statement state = conn.createStatement();
		
		int i = state.executeUpdate("delete from st_user where student_id = 8");
		
		System.out.println("record inserted " + i+ " row affected");

	}
}
