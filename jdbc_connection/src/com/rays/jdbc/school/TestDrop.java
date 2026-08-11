package com.rays.jdbc.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDrop {
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");
		
		Statement state = conn.createStatement();
		
		state.executeUpdate("Drop table st");
		
		System.out.println("table droped.");
	}
}
