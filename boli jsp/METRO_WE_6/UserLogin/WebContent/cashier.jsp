<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet" type = "text/css" href="style.css"> -->	
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


</head>
<body>
	
	<!-- Login Verification code  -->
	<%
		String user = (String)session.getAttribute("username");
		if(user == null)
		{
			response.sendRedirect("index.jsp?notlogged=true");
		}
	%>
	<!-- Login code End -->
	
	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
	
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
		
						<form method = "post" action = "ButtonServlet" class = "login100-form validate-form">
									
									<span class="login100-form-title p-b-37">
										<h4>SCHOOL MANAGEMENT SYSTEM</h4>
									</span>
									
									<span class="login100-form-title p-b-37">
										<h3>PAYMENT</h3>
									</span>
									
									<div class="container-login100-form-btn">
										<input type = "submit" name = "CrMakePayment" value = "Create & Make payment" class="login100-form-btn">
									</div>
									
									<center><p>To create the table in DB</p></center>
									
									<div class="container-login100-form-btn">
										<a href = "UpMakePayment.jsp" ><input type = "submit" name = "CrupdatePayment" value = "Create & New Balance Update" class="login100-form-btn">
										</a>
									</div>
									
									<center><p>To create the balance table in DB</p></center>
									
									<div class="container-login100-form-btn">
										<input type = "submit" name = "MakePayment" value = "Make payment" class="login100-form-btn">
									</div>
									<br/>
									
									<div class="container-login100-form-btn">
										<a href = "UpMakePayment.jsp" ><input type = "submit" name = "UpMakePayment" value = "Enter new balance" class="login100-form-btn"></a>
									</div>
									<br/>
									
									<div class="container-login100-form-btn">
										<a href = "RemovePayment.jsp" ><input type = "submit" name = "RemovePayment" value = "Remove Payment" class="login100-form-btn"></a>
									</div>
									<br/>
									
									<div class="container-login100-form-btn">
										<a href = "EditPayment.jsp" ><input type = "submit" name = "EditPayment" value = "Edit Payment Amount" class="login100-form-btn"></a>
									</div>
									<br/>
									
									<div class="container-login100-form-btn">
									<a href = "FullAmount.jsp" ><input type = "submit" name = "FullAmount" value = "Get Total Amount of payments" class="login100-form-btn"></a>
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






