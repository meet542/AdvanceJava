package com.rays.preparedstatement.bean;

import java.text.SimpleDateFormat;

import com.rays.preparedstatement.UserModel;

public class TestUserModel {
	public static com.rays.preparedstatement.bean.UserModel model = new com.rays.preparedstatement.bean.UserModel();
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
		testDelete();
	}

	public static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(9);
		bean.setFirstName("xyz");
		bean.setLastName("xyz");
		bean.setLoginId("xyz@gmail.com");
		bean.setPassword("xyz123");
		bean.setDob(sdf.parse("2001-01-01"));

		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstName("xyz");
		bean.setLastName("xyz");
		bean.setLoginId("xyz@gmail.com");
		bean.setPassword("xyz123");
		bean.setDob(sdf.parse("2001-01-01"));

		model.update(bean);
	}

	public static void testDelete() throws Exception {
		model.delete(11);
	}

}
