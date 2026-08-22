<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Login</h1>
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