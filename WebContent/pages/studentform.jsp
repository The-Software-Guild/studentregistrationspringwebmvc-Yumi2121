<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
	<h2>Please enter employee details: </h2>
	
	<form:form  method="post" modelAttribute="e">
		<spring:message code="e.name" /><form:input path="name"/><form:errors path="name" /><br />
		<spring:message code="e.age" /><form:input path="age"/><form:errors path="age" /><br />
		<spring:message code="e.mobile" /><form:input path="mobile"/><form:errors path="mobile" /><br />
		<spring:message code="e.address" /><form:input path="address"/><form:errors path="address" /><br />
		<input type="submit" value="Submit"/><br />
		<input type="reset" value="Reset"><br />
	</form:form>
</body>
</html>
