package com.rays.jdbc.school.preStmt;

import java.sql.SQLException;

public class test {
	public static userModel model = new userModel();
	public static void main(String[] args) throws Exception{
		//testAdd();
//		testUpdate();
		testDelete();
	}
	
	public static void testAdd() throws SQLException {
		model.Add(11, "Ghanshyam", 21, "M", "Varanasi", "cs", 88, "9876564916");
	}
	
	public static void testUpdate() throws Exception{
		model.update(11, "Ghanshyam", 19,  "M", "Varanasi", "cs", 88, "9876564916");
	}
	
	public static void testDelete() throws Exception{
		model.delete(11);
	}
}
