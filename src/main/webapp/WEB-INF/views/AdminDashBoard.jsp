<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin DashBoard</title>
<style><%@include file="/WEB-INF/static/css/AdminDashBoard.css"%></style>
</head>
<body style="background-color: #E0FFFF">

<div align="center">

<div style="background-color: #E8FCF7; font-family: cursive;" >
<h1>Admin DashBoard</h1>

	<h2>Applicants List</h2>
</div>
	<table align="center" cellspacing="15" class="table">

		<tr>
			<th>ID</th>
			<th>User Name</th>
<!-- 			<th>Password</th> -->
			<th>First Name</th>
			<th>Last Name</th>
			<th>E-Mail</th>
			<th>Address</th>
			<th>Date Of Birth</th>
<!-- 				<th>C.V</th> -->
			<th>Mobile No</th>
			<th>Gender</th>
		</tr>

		<c:forEach items="${applicantsList}" var="applicant">

			<tr>

				<td>${applicant.id}</td>
				<td>${applicant.username}</td>
<%-- 				<td>${applicant.password}</td> --%>
				<td>${applicant.firstName}</td>
				<td>${applicant.lastName}</td>
				<td>${applicant.eMail}</td>
				<td>${applicant.address}</td>
				<td>${applicant.birthDate}</td>
<%-- 				<td>${applicant.cv}</td> --%>
				<td>${applicant.mobileNo}</td>
				<td>${applicant.gender}</td>

				

			</tr>

		</c:forEach>


	</table>


	<br>
	<br>
	<hr>
	<br>
	<br>

	<form action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="LogOut" />
	</form>

</div>

</body>
</html>