<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>

	<%
	String succMsg = (String) request.getAttribute("succMsg");
	%>
	<%
	String errMsg = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>

	<%
	List<UserBean> list = (List<UserBean>) request.getAttribute("list");
	int pageNo = (int) request.getAttribute("pageNo");
	int pageSize = (int) request.getAttribute("pageSize");
	Iterator<UserBean> it = list.iterator();
	int index = (pageNo - 1) * pageSize + 1;
	%>

	<div align="center">
		<h1>User List</h1>
		<h3>
			PageNo=<%=pageNo%></h3>

		<h3 style="color: green"><%=succMsg != null ? succMsg : ""%></h3>
		<h3 style="color: red"><%=errMsg != null ? errMsg : ""%></h3>

		<form action="UserListCtl.do" method="post">
			<input type="hidden" name="pageNo" value="<%=pageNo%>">


			<table width="100%" border="1px">
				<tr>
					<th>Delete</th>
					<th>S No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Dob</th>
					<th>Update</th>
				</tr>

				<%
				while (it.hasNext()) {
					UserBean bean = it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLoginId()%></td>
					<td><%=bean.getDob()%></td>
					<td><a href="UserCtl.do?id=<%=bean.getId()%>">edit</a></td>
				</tr>
				<%
				}
				%>

			</table>


			<table width="100%">
				<tr>
					<td><input type="submit" name="operation" value="previous"
						<%=pageNo == 1 ? "disabled" : ""%>></td>
					<td><input type="submit" name="operation" value="delete"></td>
					<td align="right"><input type="submit" name="operation"
						value="next" <%=list.size() < 5 ? "disabled" : ""%>></td>
				</tr>
			</table>

		</form>
	</div>


	<%@ include file="Footer.jsp"%>

</body>
</html>