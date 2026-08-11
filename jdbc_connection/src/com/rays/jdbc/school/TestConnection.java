package com.rays.jdbc.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// step 1 load driver class in Class.forName() method
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2 make connection to the database using DriverManager
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");

		System.out.println("connection established successfully: " + conn.getCatalog() + "\n");

		// step 3. create Statement and get ResultSet or insert, update and delete
		// records
		Statement stmt = conn.createStatement();

		// step 4 get records
		ResultSet rs = stmt.executeQuery("select * from students");

	}

}
