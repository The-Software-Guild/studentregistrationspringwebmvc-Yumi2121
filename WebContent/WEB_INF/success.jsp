<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
	<% 
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String mobile = request.getParameter("mobile");
	String address = request.getParameter("address");
	%>
	
	<h2>Registered Successfully!!!</h2><br>
	<h3 style="color: purple;">Your details are: </h3>
	
	<h3>Name is: <%=name %> </h3>
	<h3>Age is: <%=age %> </h3>
	<h3>MobileNo is: <%=mobile %> </h3>
	<h3>Address is: <%=address %> </h3>
</body>
</html>
