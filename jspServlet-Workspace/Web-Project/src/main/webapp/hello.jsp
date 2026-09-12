<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <% %>  scriptlet tag use to write java code in jsp pages --%>
<%-- <%= %> expression tag use to print java variable, values and objects in jsp pages --%>

	<%
	for (int i = 1; i <= 10; i++) {
	%>

	<h1><%=i%>Hello World
	</h1>

	<%
	}
	%>
</body>
</html>