<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String succ = (String) request.getAttribute("succesMessage");
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1><%=bean != null ? "Update User" : "Add User"%></h1>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
		<form action="UserCtl.do" method="post">

			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">

			<table>
				<tr>
					<th>FirstName</th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="Enter First Name"></td>
				</tr>

				<tr>
					<th>LastName</th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="Enter Last Name"></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type="email" name="login"
						value="<%=bean != null ? bean.getLoginId() : ""%>"
						placeholder="Enter email id"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="Enter password"></td>
				</tr>
				<tr>
					<th>D.O.B</th>
					<td><input type="date" name="dob"
						value="<%=bean != null ? bean.getDob() : ""%>"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "Update" : "Save"%>"></td>
				</tr>
			</table>
		</form>
	</div>

	<%@ include file="Footer.jsp"%>
</body>