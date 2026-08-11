package com.rays.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root@789");

		Statement state = conn.createStatement();

		int i = state.executeUpdate(
				"create table st_user2(id int primary key, firstName varchar(50), lastName varchar(50), loginId varchar(50), password varchar(50), dob date)");

		System.out.println("table created.");
	}
}
