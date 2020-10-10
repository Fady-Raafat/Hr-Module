<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style><%@include file="/WEB-INF/static/css/login.css"%></style>
<title>User Login Form</title>
</head>
<body style="background-color: #E0FFFF">
<div class="imgdiv">

<img class= "image"  alt="" src="${pageContext.request.contextPath}/images/Recruitment.jpg"/>

</div>

<div align="center" class="login" >


<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">


<table>

<tr>
<td>User Name:</td>
<td></td>
<td><input type="text" name="username"  /></td>
</tr>

<tr>
<td>Password:</td>
<td></td>
<td><input type="password" name="password"/></td>
</tr>

<tr>
<td></td>
<td></td>
<td align="center"><input type="submit" value="Login"></td>
</tr>



<tr>
<td></td>
<td></td>
<td align="center">   </td>
</tr>

<tr>
<td></td>
<td></td>
<td align="center">   </td>
</tr>

<tr>
<td></td>
<td></td>
<td align="center"><a href="${pageContext.request.contextPath}/register">Register New Applicant</a></td>
</tr>
</table>
<br><br>
<div style="color: red;">
<c:if test="${param.error != null}">
	<i >Invalid User Name Or Password !</i>
</c:if>

<c:if test="${param.logout != null}">
	<i>You Have Been Logged Out Successfully !</i>
</c:if>
</div>
</form:form>

</div>

</body>
</html>