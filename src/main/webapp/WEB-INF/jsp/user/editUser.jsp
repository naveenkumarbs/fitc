
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FITC</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<h1>Edit Profile</h1>
	<form>
		<table style="with: 50%">
			<tr>
				<td>First Name</td>
				<td><input type="text" id="firstname"  value="${firstname}"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" id="lastname" value="${lastname}"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" id="address" value="${address}"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" id="email" value="${email}"/></td>
			</tr>
			<tr>
				<td>Contact No</td>
				<td><input type="text" id="phone" value="${phone}"/></td>
			</tr>
			<tr>
			<td> <input type="hidden" id="userId" value="${userId}" /> </td>
			</tr>
		</table>
		
		 <input
			type="button" value="Update" align="right" onclick="updateProfileDetails()" />
			
		<p> Update Status: </p> <div id="updateStatus"> Pending </div>
	</form>
</body>
</html>