package com.rays.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class testInsert {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root@789");
		
		Statement state = conn.createStatement();
		
		int i = state.executeUpdate("insert into st_user value(6,'Kamal','Singh', 'singh123', 'pass@765', '2004-12-03')");
		
		i = state.executeUpdate("insert into st_user value(7,'Priya','Verma','rahul123','pass@123','2003-05-14')");
		
		i = state.executeUpdate("insert into st_user value(8,'Amit','Patel','amit456','pass@456','2004-08-21')");
		
		System.out.println("value inserted " + i + " rows affected.");
	}
}
