package com.rays.student;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class StudentModel {

	Connection conn = null;

	public void createTable() throws Exception {

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement prestmt = conn.prepareStatement(
					"create table student(studentId int primary key, name varchar(50), email varchar(50), mobileNo varchar(10), course varchar(50))");

			prestmt.executeUpdate();

			conn.commit();

			System.out.println("Table created successfully!!");

		} catch (Exception e) {
			e.getStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void insertIntoTable(StudentBean bean) throws Exception {

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement prestmt = conn.prepareStatement("insert into student values(?,?,?,?,?)");

			prestmt.setLong(1, bean.getStudentId());
			prestmt.setString(2, bean.getName());
			prestmt.setString(3, bean.getEmail());
			prestmt.setString(4, bean.getMobileNo());
			prestmt.setString(5, bean.getCourse());

			int i = prestmt.executeUpdate();

			conn.commit();

			System.out.println("data inserted successfully, row affected : " + i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void updateTable(StudentBean bean) throws Exception {

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement prestmt = conn.prepareStatement(
					"update student set name = ?, email = ?, mobileNo = ?, course = ? where studentId = ?");

			prestmt.setString(1, bean.getName());
			prestmt.setString(2, bean.getEmail());
			prestmt.setString(3, bean.getMobileNo());
			prestmt.setString(4, bean.getCourse());
			prestmt.setLong(5, bean.getStudentId());
			
			int i = prestmt.executeUpdate();
			
			conn.commit();
			
			System.out.println("data updated successfully, row affected : " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}

	public List<StudentBean> search(StudentBean bean) throws Exception{
		List<StudentBean> list = new ArrayList<StudentBean>();
		Connection conn = null;
		StringBuffer sql = new StringBuffer("select * from student where 1=1");
		
		if(bean!=null) {
			if(bean.getStudentId()>0) {
				sql.append(" and studentId = " + bean.getStudentId());
			}
			
			if(bean.getName()!=null && bean.getName().length()>0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			
			if(bean.getEmail()!=null && bean.getEmail().length()>0) {
				sql.append(" and email like '" + bean.getEmail() + "%'");
			}
			
			if(bean.getMobileNo()!=null && bean.getMobileNo().length()>0) {
				sql.append(" and mobileNo like '" + bean.getMobileNo() + "%'");
			}
			
			if(bean.getCourse()!=null && bean.getCourse().length()>0) {
				sql.append(" and course like '" + bean.getCourse() + "%'");
			}
		}
		
		try {
			conn= JDBCDataSource.getConnection();
			
			PreparedStatement prestmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = prestmt.executeQuery();
			
			while(rs.next()) {
				bean = new StudentBean();
				bean.setStudentId(rs.getLong("studentId"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setMobileNo(rs.getString("mobileNo"));
				bean.setCourse(rs.getString("course"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return list;
	}

	public void deleteTable() throws Exception {

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement prestmt = conn.prepareStatement("drop table student");

			prestmt.executeUpdate();

			conn.commit();

			System.out.println("Table deleted successfully!!");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();

		}

	}

}
