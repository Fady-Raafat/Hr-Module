<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uploads</title>
</head>
<body style="background-color: #E0FFFF">
<div align="center" style="font-family: cursive;">
<Form action="${pageContext.request.contextPath}/saveupload" method="POST" enctype="multipart/form-data">
<table>
<tr>

<td>Upload C.V</td>
<td>
<input type="file" name="file" >*.pdf format max. size 10 MB
</td>
<td>
<input type="submit" value="upload">
</td>

</tr>

</table>
</Form>
<br>
<hr>
<br>

Already Registered? <a href="${pageContext.request.contextPath}/">Go To Login Page</a>

<br><br>
<hr>
<br>
<div>${message}</div>

<br>
</div>
</body>





















</html>