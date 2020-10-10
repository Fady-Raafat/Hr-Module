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
<div align="center">

<div style="background-color: #E8FCF7; font-family: cursive;" >
<h1>Welcome To Our Company, Wish You Good Luck!</h1>
</div>

<hr><br><br>
<Form action="${pageContext.request.contextPath}/saveapplicantdata" method="POST" enctype="multipart/form-data">

<table>

<tr>
<td>User Name:</td>
<td></td>
<td><input type="text" name="username"/></td>
</tr>

<tr>
<td>Password:</td>
<td></td>
<td><input type="password" name="password" placeholder="not less than 6 characters"/></td>
</tr>

<tr>
<td>First Name:</td>
<td></td>
<td><input type="text" name="firstName"/></td>
</tr>

<tr>
<td>Last Name:</td>
<td></td>
<td><input type="text" name="lastName"/></td>
</tr>

<tr>
<td>E-Mail:</td>
<td></td>
<td><input type="text" name="eMail" placeholder="xxx@xxx.xxx"/></td>
</tr>

<tr>
<td>Address:</td>
<td></td>
<td><input type="text" name="address"/></td>
</tr>

<tr>
<td>Date Of Birth:</td>
<td></td>
<td><input type="text" name="birthDate" placeholder="dd/MM/yyyy"/></td>
</tr>

<tr>
<td>Mobile No.</td>
<td></td>
<td><input type="text" name="mobileNo"/></td>
</tr>


<tr>
<td>Gender:</td>
<td></td>
<td><input type="radio" name="gender" value="male" > Male</td>
</tr>

<tr>
<td></td>
<td></td>
<td><input type="radio" name="gender" value="female"> Female</td>
</tr>

<tr>
<td><br><br></td>
<td/>
<td align="center"><input type="submit" value="Save" /></td>
</tr>


</table>
</Form>

<br>
<hr>


Already Registered? <a href="${pageContext.request.contextPath}/">Go To Login Page</a>

<br><br>
<div style="color: red;" >
${registration_status}
</div>
</div>
</body>





















</html>