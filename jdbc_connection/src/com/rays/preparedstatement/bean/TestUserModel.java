package com.rays.preparedstatement.bean;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static com.rays.preparedstatement.bean.UserModel model = new com.rays.preparedstatement.bean.UserModel();
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testAuthenticate();
		testSearch();
//		testFindByLoginId();
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
	
	public static void testFindByLoginId() throws Exception {
		
		UserBean bean = model.findByLoginId("");
		
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
	}

	public static void testFindByPk() throws SQLException {

		UserBean bean = model.findByPk(3);

		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());

	}

	public static void testAuthenticate() throws Exception {

		UserBean bean = model.authenticate("sharma632", "password");

		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());

	}

	public static void testSearch() throws Exception {

		UserBean bean = new UserBean();
		//bean.setDob(sdf.parse("2006-01-10"));
		// bean.setFirstName("ram");
		List<UserBean> list = model.search(bean, 1, 5);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		}

	}

}
