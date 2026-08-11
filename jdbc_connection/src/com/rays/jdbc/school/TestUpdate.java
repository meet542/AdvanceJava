package com.rays.jdbc.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root" ,"root@789");
		
		Statement state = conn.createStatement();
		
		int i = state.executeUpdate("update students set name = 'Ghanshyam' where student_id = 4");
		
		System.out.println("record updated " + i + " row affected.");
	}
}
