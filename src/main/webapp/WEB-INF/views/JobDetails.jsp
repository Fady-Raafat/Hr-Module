<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Registration Form</title>
</head>
<body style="background-color: #E0FFFF">
<div align="center" style=" font-family: cursive;">
<Form action="${pageContext.request.contextPath}/savejobdata" method="POST" enctype="multipart/form-data">

<table>

<tr height="13">
<td></td>
<td></td>
<td></td>
</tr>

<tr height="13">
<td>Select Job Category:</td>
<td></td>
<td>	
	<select name="jobName">

	<option value="engineering"> Engineering </option>
	<option value = "computerScience"> Human Resources </option>
	<option value = "sales"> Sales </option>
	<option value ="technicalSupport"> Technical Support </option>
	<option value ="maintenance"> Maintenance </option>
	<option value ="management"> Management </option>
	
	</select>

</td>
</tr>

<tr>
<td>Experience Years:</td>
<td/>
<td>
	<select name="reqExperienceYears">
	<c:forEach var="i" begin="1" end="40" step="1">
			<option value="${i}">
			
				<c:out value="${i}"/>	
				
			</option>
	</c:forEach>

	</select>


</td>
</tr>

<tr>
<td>Job Description:</td>
<td/>
<td>

<textarea name="description" rows="10" cols="120">
</textarea>
</td>
</tr>
<tr>
<td></td>
<td/>
<td align="center"><input type="submit" value="Save" /></td>
</tr>
</table>
</Form>

<br>
<hr>


Already Registered? <a href="${pageContext.request.contextPath}/">Go To Login Page</a>

<br><br>
</div>
</body>





















</html>