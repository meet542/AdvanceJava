package com.rays.jdbc.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root@789");
		
		Statement state = conn.createStatement();
		
		state.executeUpdate("create table st(student_id int primary key,name varchar(50), age int, gender varchar(1), city varchar(50), cource varchar(50), marks float, phone varchar(10))");
		
		System.out.println("table created.");
	}
}
