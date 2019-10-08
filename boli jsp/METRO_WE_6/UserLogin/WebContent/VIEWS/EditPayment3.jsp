<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Payment</title>

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
	  var a = document.forms["form"]["memID"].value;
	  var b = document.forms["form"]["fee"].value;
	  var c = document.forms["form"]["exCur"].value;
	  var d = document.forms["form"]["additional"].value;
	  
	  if (a == "" || b == "" || c == "" || d == "") {
	    alert("Mandotary fields must be filled out");
	    return false;
	  }
	}

</script>

</head>
<body>

	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
					
					<form method = "post" action = "editPayment3" class = "form" name = "form" onsubmit  = "return validateForm()" class="login100-form validate-form">
						
						<span class="login100-form-title p-b-37">
								Edit balance
						</span>
						
							<div class="wrap-input100 validate-input m-b-20">
								<input type = "text" name = "memID" class="input100" placeholder="Member ID">
								<span class="focus-input100"></span>
							</div>
							
							<div class="wrap-input100 validate-input m-b-20">
								<input type = "text" name = "fee" class="input100" placeholder="Fee">
								<span class="focus-input100"></span>
							</div>
							
							<div class="wrap-input100 validate-input m-b-20">
								<input type = "text" name = "exCur" class="input100" placeholder="Extra Curricular">
								<span class="focus-input100"></span>
							</div>
							
							<div class="wrap-input100 validate-input m-b-20">
								<input type = "text" name = "additional" class="input100" placeholder="Additonal">
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