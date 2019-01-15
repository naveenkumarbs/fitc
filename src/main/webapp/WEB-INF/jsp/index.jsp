<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<jsp:include page="common/menu.jsp" />
<body>
	<div>
		<table>
			<tr>
				<td>
					<div id="registrationdiv" align="left">
						<jsp:include page="login/newUser.jsp" />
					</div>
				</td>
				<td> <pre>      </pre>  </td>
				<td> </td>
				
				<td>
					<div id="logindiv" align="right">
						<jsp:include page="login/loginform.jsp" />
					</div>
				</td>

			</tr>
		</table>
	</div>
</body>
</html>