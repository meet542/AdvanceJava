package com.rays.jdbc.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");

		System.out.println("connection established successfully to " + conn.getCatalog() + " database.");

		Statement state = conn.createStatement();

		int i = state.executeUpdate(
				"insert into students values(9,'Ghanshyam',23,'M','Varanasi','Civil',98.2,'9735104726')");

		System.out.println("record inserted " + i + " row affected");

	}
}
