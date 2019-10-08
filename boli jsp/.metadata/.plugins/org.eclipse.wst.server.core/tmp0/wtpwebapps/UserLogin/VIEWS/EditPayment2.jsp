<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Logged In</title>

<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->


<script>

function validateForm() {
	  var a = document.forms["form"]["payID"].value;
	  var b = document.forms["form"]["memID"].value;
	  var c = document.forms["form"]["payFor"].value;
	  var d = document.forms["form"]["payMethod"].value;
	  var e = document.forms["form"]["payID"].value;
	  var f = document.forms["form"]["amount"].value;
	  var g = document.forms["form"]["cardNumber"].value;
	  var h = document.forms["form"]["bank"].value;
	  
	  if (a == "" || b == "" || c == "" || d == "" || e == "" || f == "") {
	    alert("Mandotary fields must be filled out");
	    return false;
	  }
	  else if(d == "Card" && g == "" || h == "" )
	  {
		  alert("If payment method is card, required fields must be filled out OR If payment method is cash, give card number as 0 and bank as Null");
		    return false;
	  }
	  
	}

</script>

</head>
<body>
	
	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
			
							<form method = "post" action = "editPayment2" class = "form" name = "form" onsubmit  = "return validateForm()" class="login100-form validate-form"> 
								
								<span class="login100-form-title p-b-37">
								Edit payment
								</span>
										
										<div class="wrap-input100 validate-input m-b-20">
											<input type = "text" name = "payID" class="input100" placeholder="Payment ID">
											<span class="focus-input100"></span>
										</div>
										
										<div class="wrap-input100 validate-input m-b-20" >
											<input type = "text" name = "memID" class="input100" placeholder="Member ID">
											<span class="focus-input100"></span>
										</div>
										
										<div class="wrap-input100 validate-input m-b-20" >
											<input type = "text" name = "payFor" class="input100" placeholder="Payment For">
											<span class="focus-input100"></span>
										</div>
										
										<div class="wrap-input100 validate-input m-b-20" >
											<input type = "text" name = "payMethod" class="input100" placeholder="Payment Method">
											<span class="focus-input100"></span>
										</div>
										
										<div class="wrap-input100 validate-input m-b-20" >
											<input type = "text" name = "cardNumber" class="input100" placeholder="Card Number">
											<span class="focus-input100"></span>
										</div>
										
										<div class="wrap-input100 validate-input m-b-20" >
											<input type = "text" name = "bank" class="input100" placeholder="Bank">
											<span class="focus-input100"></span>
										</div>
										
										<div class="wrap-input100 validate-input m-b-20" >
											<input type = "text" name = "amount" class="input100" placeholder="Amount">
											<span class="focus-input100"></span>
										</div>
									
									<br/>
										
										<div class="container-login100-form-btn">
											<input type = "submit" name = "submit" value = "Edit" class="login100-form-btn">
										</div>	
										
										<div class="text-center p-t-57 p-b-20">
											<span class="txt1">
												By Kevin Gomez
											</span>
										</div>
									
								
							</form>
			</div>
	</div>
	
</body>
</html>