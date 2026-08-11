package com.rays.jdbc.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");

		Statement state = conn.createStatement();

		ResultSet rs = state.executeQuery("select * from students");

		while (rs.next()) {
			System.out.print(rs.getInt("student_id"));
			System.out.print("\t" + rs.getString("name"));
			System.out.print("\t" + rs.getInt("age"));
			System.out.print("\t" + rs.getString("gender"));
			System.out.print("\t" + rs.getString("city"));
			System.out.print("\t" + rs.getString("cource"));
			System.out.print("\t" + rs.getFloat("marks"));
			System.out.println("\t" + rs.getString("phone"));
		}
	}
}
