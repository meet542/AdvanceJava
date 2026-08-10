package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");
		
		System.out.println("connection established successfully to " + conn.getCatalog() + " database.");
		
		Statement state = conn.createStatement();
		
		int i = state.executeUpdate("insert into students values(9,'Ghanshyam',23,'M','Varanasi','Civil',98.2,'9735104726')");
		
		System.out.println("record inserted " + i+ " row affected");
		
//		while (i.next()) {
//			System.out.print(i.getInt("student_id"));
//			System.out.print("\t" + insert.getString("name"));
//			System.out.print("\t" + insert.getInt("age"));
//			System.out.print("\t" + insert.getString("gender"));
//			System.out.print("\t" + insert.getString("city"));
//			System.out.print("\t" + insert.getString("cource"));
//			System.out.print("\t" + insert.getInt("marks"));
//			System.out.println("\t" + insert.getString("phone"));
//
//		}
		
	}
}
