<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- Navigation -->
	<ul id="nav">
		<li><a href="/">Home</a></li>
		<li><a href="#">Categories</a>
			<ul>
				<li><a href="#">All</a>
					<ul>
						<li><a href="#">Category 1</a>
							<ul class="droprightMenu">
								<li><a href="#">Category 1.2</a>
									<ul>
										<li><a href="#">Category 1.2.1</a></li>
									</ul></li>
								<li><a href="#">Category 1.3</a>
									<ul>
										<li><a href="#">Category 1.3.1</a></li>
									</ul></li>
								<li><a href="#">Category 1.4</a></li>
							</ul></li>
						<li><a href="#">Category 2</a></li>
						<li><a href="#">Category 3</a></li>
						<li><a href="#">Category 4</a></li>
					</ul></li>
				<li><a href="#">Manage</a></li>
			</ul></li>

		<li><a href="#">${userName}'s Profile</a>
			<ul>
				<c:choose>

					<c:when test="${empty userName}">
						<li><a href="login?userName=Naveen">Login</a></li>
						<li><a href="#">Register</a></li>
					</c:when>

					<c:otherwise>
						<li><a href="logout">Logout</a></li>
						<li><a href="#">Edit Profile</a></li>
						<li><a href="#">My Posts</a></li>
					</c:otherwise>
				</c:choose>
			</ul></li>
		<li><a href="#">Help</a></li>
	</ul>
</body>
</html>