package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandlingSchool {
	public static void main(String[] args) throws Exception {
		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");

			conn.setAutoCommit(false);

			System.out.println("connection established successfully to " + conn.getCatalog() + " database.");

			Statement state = conn.createStatement();

			int i = state.executeUpdate(
					"insert into students values(9, 'Vikas Yadav', 22, 'M', 'Lucknow', 'SQL', 73.5, '9876543218')");
			i = state.executeUpdate(
					"insert into students values(10, 'Pooja Mishra', 21, 'F', 'Indore', 'Java', 87.0, '9876543219')");
			i = state.executeUpdate(
					"insert into students values(10, 'Pooja Mishra', 21, 'F', 'Indore', 'Java', 87.0, '9876543219')");
			i = state.executeUpdate(
					"insert into students values(11, 'Karan Joshi', 20, 'M', 'Bhopal', 'C++', 81.5, '9876543220')");

			conn.commit();

		} catch (Exception e) {
			System.out.println("exception:" + e.getMessage());
			conn.rollback();
		} finally {
			conn.close();
		}

	}
}
