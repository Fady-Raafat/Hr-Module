<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Applicant</title>
</head>
<body style="background-color: #E0FFFF">
<div align="center">
	<h2>Edit Applicant</h2>

	<form action="${pageContext.request.contextPath}/saveUpdatedApplicant" method="post">

		<table>

			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${editableApplicant.id}" readonly /></td>
			</tr>
			
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" value="${editableApplicant.username}" /></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" value="${editableApplicant.password}" /></td>
			</tr>

	
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" value="${editableApplicant.firstName}" /></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" value="${editableApplicant.lastName}" /></td>
			</tr>
			
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="eMail" value="${editableApplicant.eMail}" /></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="${editableApplicant.address}" /></td>
			</tr>
			<tr>
				<td>Birth Date</td>
				<td><input type="text" name="birthDate" value="${editableApplicant.birthDate}" /></td>
			</tr>
			
<!-- 			<tr> -->
<!-- 				<td>C.V</td> -->
<%-- 				<td><input type="text" name="mobileNo" value="${editableApplicant.cv}" /></td> --%>
<!-- 			</tr> -->
			
			<tr>
				<td>Mobile No</td>
				<td><input type="text" name="mobileNo" value="${editableApplicant.mobileNo}" /></td>
			</tr>
			
			
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender" value="${editableApplicant.gender}" /></td>
			</tr>

			
			
			<tr>
				<td></td>
				<td align="center"><input type="submit" value="Save" /></td>
			</tr>
			
		</table>

	</form>
</div>
</body>
</html>