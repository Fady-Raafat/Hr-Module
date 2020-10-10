<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>

<body style="background-color: #E0FFFF">
<div align="center">
<div style="background-color: #E8FCF7; font-family: cursive;" >
<h1>Welcome <sec:authentication property="principal.username"/></h1>
</div>
<br><br>
<%-- Role(s): <sec:authentication property="principal.authorities"/> --%>

<sec:authorize access="hasRole('MANAGER')"> 
	<a href="${pageContext.request.contextPath}/management">Management DashBoard</a>
</sec:authorize>

<br><br>

<sec:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath}/admin">Administration DashBoard</a>
 </sec:authorize>
 
 <br><br>

<sec:authorize access="hasRole('USER')">
<a href="${pageContext.request.contextPath}/applicant">Check Your Job Application Status</a>
 </sec:authorize>

 <br><br><hr><br><br>

<form:form action="${pageContext.request.contextPath}/logout">
	<input type="submit" value="LogOut"/>
</form:form>
</div>
</body>
</html>