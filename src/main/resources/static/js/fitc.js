$(document).ready(function(){
	hideAll();
   showPopup();
});

function validateUser(){
	
	var userName = $('#userName').val();
	console.log("Validating User"+userName)
	var param = {userName: userName};
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