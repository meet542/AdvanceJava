<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

	<%-- <%
	boolean login = (boolean) request.getAttribute("login");
	String msg = login ? (String) request.getAttribute("succMsg") : (String) request.getAttribute("errMsg");
	%> --%>

	<%
	String succMsg, errMsg;
	succMsg = (String) request.getAttribute("succMsg");
	errMsg = (String) request.getAttribute("errMsg");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Login</h1>
		<%-- <h3 style="color: <%=login ? "green" : "red"%>;">
			<%=msg%>
		</h3>
 --%>

		<h3 style="color:red"><%=errMsg != null ? errMsg : ""%></h3>
		<h3 style="color:green"><%=succMsg != null ? succMsg : ""%></h3>

		<form action="LoginCtl" method="post">
			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="Enter email id"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="Enter password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="signIn"></td>
				</tr>
			</table>
		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>


</html>