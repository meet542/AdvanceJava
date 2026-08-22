package com.rays.student;

import java.util.Iterator;
import java.util.List;

public class TestStudentModel {

	public static StudentModel model = new StudentModel();

	public static void main(String[] args) throws Exception {
//		testCreate();
//		testDelete();
//		testInsert();
//		testUpdate();
		testSearch();
	}

	public static void testCreate() throws Exception {
		model.createTable();
	}

	public static void testInsert() throws Exception {
		StudentBean bean = new StudentBean();

		bean.setStudentId(1);
		bean.setName("Bantu");
		bean.setEmail("xyz@gmail.com");
		bean.setCourse("MBA");
		bean.setMobileNo("9876510462");
		
		model.insertIntoTable(bean);

//		bean.setStudentId(2);
//		bean.setName("Rahul");
//		bean.setEmail("rahul@gmail.com");
//		bean.setCourse("BCA");
//		bean.setMobileNo("9876543210");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(3);
//		bean.setName("Aman");
//		bean.setEmail("aman@gmail.com");
//		bean.setCourse("B.Tech");
//		bean.setMobileNo("9876543211");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(4);
//		bean.setName("Priya");
//		bean.setEmail("priya@gmail.com");
//		bean.setCourse("MCA");
//		bean.setMobileNo("9876543212");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(5);
//		bean.setName("Neha");
//		bean.setEmail("neha@gmail.com");
//		bean.setCourse("MBA");
//		bean.setMobileNo("9876543213");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(6);
//		bean.setName("Karan");
//		bean.setEmail("karan@gmail.com");
//		bean.setCourse("BBA");
//		bean.setMobileNo("9876543214");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(7);
//		bean.setName("Riya");
//		bean.setEmail("riya@gmail.com");
//		bean.setCourse("B.Tech");
//		bean.setMobileNo("9876543215");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(8);
//		bean.setName("Vivek");
//		bean.setEmail("vivek@gmail.com");
//		bean.setCourse("MCA");
//		bean.setMobileNo("9876543216");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(9);
//		bean.setName("Anjali");
//		bean.setEmail("anjali@gmail.com");
//		bean.setCourse("MBA");
//		bean.setMobileNo("9876543217");
//		
//		model.insertIntoTable(bean);
//
//		bean.setStudentId(10);
//		bean.setName("Rohit");
//		bean.setEmail("rohit@gmail.com");
//		bean.setCourse("BCA");
//		bean.setMobileNo("9876543218");
//
//		model.insertIntoTable(bean);
	}

	public static void testUpdate() throws Exception {
		StudentBean bean = new StudentBean();

		bean.setStudentId(1);
		bean.setName("Rahul");
		bean.setEmail("abc@gmail.com");
		bean.setMobileNo("9876510472");
		bean.setCourse("BBA");

		model.updateTable(bean);
	}

	public static void testSearch() throws Exception {
		StudentBean bean = new StudentBean();

//		bean.setStudentId(1);
//		bean.setName("Rahul");
//		bean.setEmail("abc@gmail.com");
//		bean.setMobileNo("9876510472");
//		bean.setCourse("BBA");

		List<StudentBean> list = model.search(bean);

		Iterator<StudentBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getCourse());
		}
	}

	public static void testDelete() throws Exception {
		model.deleteTable();
	}
}
