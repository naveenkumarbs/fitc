$(document).ready(function(){
	hideAll();
	hideAllAdminOpts();
   showPopup();
});

function validateUser(){
	
	var username = $('#userName').val();
	console.log("Validating User"+username)
	var param = {username: username};
	console.log(param);
	 
	$.ajax({
	  url: 'validateUser',
	   data: param, 
	  success: function(result) {
		  console.log("Valid User");
		  return true;
	  },
	  failure: function(result) {
		  console.log("Invalid User");
		  return false;
	  }
	});
	
}

function updateProfileDetails(){

	var firstname = $('#firstname').val();
	var lastname = $('#lastname').val();
	var email = $('#email').val();
	var phone = $('#phone').val();
	var address = $('#address').val();
	var userId = $('#userId').val();
	console.log("Updating User"+firstname)
	var param = {firstname: firstname, lastname:lastname, email:email, phone:phone, address:address, userId:userId};
	console.log(param);
	 
	$.ajax({
	  url: 'updateProfileDetails',
	   data: param, 
	  success: function(result) {
		  console.log("Profile Update Success");
		  $("#updateStatus").html("Success");
	  },
	  failure: function(result) {
		  console.log("Profile Update Failure");
		  $("#updateStatus").html("Failure");
	  }
	});
	
}

function showRegistrationDiv(){
	hideAll();
	$('#registrationdiv').show();
}

function showLoginDiv(){
	hideAll();
	$('#logindiv').show();
}

function hideRegistrationDiv(){
	$('#registrationdiv').hide();
}

function hideLoginDiv(){
	$('#logindiv').hide();
}

function hideAll(){
	$('#registrationdiv').hide();
	$('#logindiv').hide();
}

function showPopup(){
	console.log("Welcome");
}

function hideAllAdminOpts(){
	$('#addMarketDiv').hide();
	$('#removeMarketDiv').hide();
	$('#addPPDiv').hide();
	$('#removePPDiv').hide();
	$('#addMarketAdminDiv').hide();
	$('#removeMarketAdminDiv').hide();
	$('#addPPAdminDiv').hide();
	$('#removePPAdminDiv').hide();
}

function showAdminDiv(adminOption){
	hideAllAdminOpts();
	
	switch(adminOption){
	case "addMarketOpt": $('#addMarketDiv').show(); break;
	case "removeMarketOpt": $('#removeMarketDiv').show(); break;
	case "addPPOpt":$('#addPPDiv').show(); break;
	case "removePPOpt": $('#removePPDiv').show(); break;
	case "addMarketAdminOpt": $('#addMarketAdminDiv').show(); break;
	case "removeMarketAdminOpt": $('#removeMarketAdminDiv').show(); break;
	case "addPPAdminOpt": $('#addPPAdminDiv').show(); break;
	case "removePPAdminOpt": $('#removePPAdminDiv').show(); break;
	}
	
}