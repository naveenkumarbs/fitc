<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/adminOperations.js"></script>
<title>FITC</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<table>
	<tr> <td>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="addMarketOpt">Add Market<br>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="removeMarketOpt">Remove Market<br>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="addMarketAdminOpt">Add Market Admin<br>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="removeMarketAdminOpt">Remove Market Admin<br>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="addPPOpt">Add Pickup-Point<br>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="removePPOpt">Remove Pickup-Point<br>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="addPPAdminOpt">Add Pickup-Point Admin<br>
	<input type="radio" name="adminOption" onclick="showAdminDiv(this.value)" value="removePPAdminOpt">Remove Pickup-Point Admin<br>
	 </td> </tr>
		<tr>
			<td>
			<!-- Add Market, Add Pickeup Point, Add MarketAdmin, Add PPAdmin, Remove Market, Remove Picket Point, Remove MarketAdmin, Remove PPAdmin -->
			<div id='addMarketDiv'>
				<form name='addMarket' method='POST' action='operations/adminOperations'>
					<h3>Add Market</h3>
					<input type='hidden' id='opName' value='addMarket'/>
					<table>
						<tr> <td>Market Name</td><td> <input type='text' id='marketName'/> </td> </tr> 
						<tr> <td>Market Address</td><td> <input type='text' id='marketAddress'/> </td> </tr> 
					</table>
					<input type='Submit' value='Add Market'/>
				</form>
			</div>
			<div id='removeMarketDiv'>
				<form name='removeMarket' method='POST' action='operations/adminOperations'>
					<h3>Remove Market</h3>
					<input type='hidden' id='opName'  value='removeMarket'/>
					<label>Market Name:</label> <input type='text' id='marketName'/> 
					<input type='Submit' value='Remove Market'/>
				</form>
			</div>
			<div id='addPPDiv'>
				<form name='addPP' method='POST' action='operations/adminOperations'>
					<h3>Add Pickup-Point</h3>
					<input type='hidden' id='opName' value='addPP'/>
					<table>
						<tr> <td>Pickup-Point Name</td><td> <input type='text' id='ppName'/> </td> </tr> 
						<tr> <td>Pickup-Point Address</td><td> <input type='text' id='ppAddress'/> </td> </tr> 
					</table>
					<input type='Submit' value='Add Pickup-Point'/>
				</form>
			</div>
			
			<div id='removePPDiv'>
				<form name='removePP' method='POST' action='operations/adminOperations'>
					<h3>Remove Pickup-Point</h3>
					<input type='hidden' id='opName'  value='removePP'/>
					<label>Pickup-Point Name:</label> <input type='text' id='ppName'/> 
					<input type='Submit' value='Remove Pickup-Point'/>
				</form>
			</div>
			
			<div id='addMarketAdminDiv'>				
				<form name='addMarketAdmin' method='POST' action='operations/adminOperations'>
					<h3>Add Market Admin</h3>
					<input type='hidden' id='opName'  value='addMarketAdmin'/>
					<table>
						<tr><td>First Name</td><td><input type='text' id='firstName'/> </td></tr>
						<tr><td>Last Name</td><td><input type='text' id='lastName'/> </td></tr>
						<tr><td>User Name</td><td><input type='text' id='userName'/> </td></tr>
						<tr><td>Phone</td><td><input type='text' id='phone'/> </td></tr>
						<tr><td>Email</td><td><input type='text' id='email'/> </td></tr>
						<tr><td>Address</td><td><input type='text' id='address'/> </td></tr>
						
					</table>
					<input type='Submit' value='Add Market Admin'/>
				</form>
				</div>
				
				<div id='removeMarketAdminDiv'>
				<form name='removeMarketAdmin' method='POST' action='operations/adminOperations'>
					<h3>Remove Market Admin</h3>
					<input type='hidden' id='opName'  value='removeMarketAdmin'/>
					<label>Market Admin Name:</label> <input type='text' id='marketAdminName'/> 
					<input type='Submit' value='Remove Market Admin'/>
				</form>
				</div>
				
				<div id='addPPAdminDiv'>
				<form name='addPPAdmin' method='POST' action='operations/adminOperations'>
					<h3>Add PP Admin</h3>
					<input type='hidden' id='opName'  value='addPPAdminOpt'/>
					<table>
						<tr><td>First Name</td><td><input type='text' id='firstName'/> </td></tr>
						<tr><td>Last Name</td><td><input type='text' id='lastName'/> </td></tr>
						<tr><td>User Name</td><td><input type='text' id='userName'/> </td></tr>
						<tr><td>Phone</td><td><input type='text' id='phone'/> </td></tr>
						<tr><td>Email</td><td><input type='text' id='email'/> </td></tr>
						<tr><td>Address</td><td><input type='text' id='address'/> </td></tr>
						
					</table>
					<input type='Submit' value='Add PP Admin'/>
				</form>
				</div>
				
				<div id='removePPAdminDiv'>
				
				<form name='removePPAdmin' method='POST' action='operations/adminOperations'>
					<h3>Remove PP Admin</h3>
					<input type='hidden' id='opName'  value='removePPAdminOpt'/>
					<label>PP Admin Name:</label> <input type='text' id='ppAdminName'/> 
					<input type='Submit' value='Remove PP Admin'/>
				</form>
				
				</div>				
			</td>
			<td>
			
			</td>
		</tr>
	</table>
</body>
</html>