package com.rays.jdbc.school.preStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userModel {

	public void Add(int student_id, String name, int age, String gender, String city, String cource, float marks,
			String phone) throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");
			conn.setAutoCommit(false);
			PreparedStatement prestmt = conn.prepareStatement("insert into students values(?,?,?,?,?,?,?,?)");

			prestmt.setInt(1, student_id);
			prestmt.setString(2, name);
			prestmt.setInt(3, age);
			prestmt.setString(4, gender);
			prestmt.setNString(5, city);
			prestmt.setNString(6, cource);
			prestmt.setFloat(7, marks);
			prestmt.setString(8, phone);

			int i = prestmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void update(int student_id, String name, int age, String gender, String city, String cource, float marks,
			String phone) throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");
			conn.setAutoCommit(false);
			PreparedStatement prestmt = conn.prepareStatement(
					"update students set name = ?, age = ?, gender = ?, city = ?, cource = ?, marks = ?, phone = ? where student_id = ?");

			prestmt.setString(1, name);
			prestmt.setInt(2, age);
			prestmt.setString(3, gender);
			prestmt.setString(4, city);
			prestmt.setString(5, cource);
			prestmt.setFloat(6, marks);
			prestmt.setString(7, phone);
			prestmt.setInt(8, student_id);
			
			int i = prestmt.executeUpdate();
			
			conn.commit();
			
			System.out.println("table updated at row : " + i);

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void delete(int student_id) throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");
			conn.setAutoCommit(false);
			PreparedStatement prestmt = conn.prepareStatement("delete from students where student_id = ?");
			prestmt.setInt(1, student_id);
			
			int i = prestmt.executeUpdate();
			
			conn.commit();
			
			System.out.println("record inserted successfully: " + i);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			conn.rollback();
		} finally {
			conn.close();
		}
	}
}
