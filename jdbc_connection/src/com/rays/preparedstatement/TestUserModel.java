package com.rays.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception {
		testAdd();
//		testUpdate();
//		testDelete();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		model.add(11, "ram", "sharma", "sharma632", "password", sdf.parse("2002-02-02"));

	}
	
	public static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		model.update(11, "ram", "sharma", "sharma632", "password", sdf.parse("2002-02-02"));
		
	}
	
	public static void testDelete() throws Exception {
		model.delete(2);
	}

}
