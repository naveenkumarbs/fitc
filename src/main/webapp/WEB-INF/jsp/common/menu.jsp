<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/fitc.js"></script>
</head>
<body>
	<!-- Navigation -->
	<ul id="nav">
		<li><a href="/">Home</a></li>
		<c:if test = "${not empty userrole }">
		<li><a href="#">Operations</a>
		<ul>
		<!-- admin, ppadmin, marketadmin,consumer, farmer -->
			<c:if test = "${userrole eq 'consumer' || userrole eq 'admin'}">
	        	 <li><a href="consumerOrders" onclick="#">Orders</a></li>
	      	</c:if>
	      	<c:if test = "${userrole eq 'farmer' || userrole eq 'admin'}">
	        	 <li><a href="farmerOperations" onclick="#">Orders</a></li>
	      	</c:if>
	      	<c:if test = "${userrole eq 'ppadmin' || userrole eq 'admin'}">
	        	 <li><a href="ppadminOperations" onclick="#">Orders</a></li>
	      	</c:if>
	      	<c:if test = "${userrole eq 'marketadmin' || userrole eq 'admin'}">
	        	 <li><a href="marketadminOperations" onclick="#">Orders</a></li>
	      	</c:if>
	      	<c:if test = "${userrole eq 'admin'}">
	        	 <li><a href="adminOperations" onclick="#">Orders</a></li>
	      	</c:if>
		</ul>
		</li>
		</c:if>
		
		<li><a href="#">${userName} Profile</a>
			<ul>
				<c:choose>

					<c:when test="${empty userName}">
						<li><a href="loginForm" onclick="#">Login</a></li>
						<li><a href="registrationForm" onclick="#">Register</a></li>
					</c:when>

					<c:otherwise>
						<li><a href="logout">Logout</a></li>
						<li><a href="editprofile?username=${userName}">Edit Profile</a></li>
					</c:otherwise>
				</c:choose>
			</ul></li>
		<li><a href="#">Help</a></li>
		<li><a href="#">About Us</a></li>
		<li><a href="#">Contact Us</a></li>
	</ul>
	
	<br/> 
	<br/>
</body>
</html>