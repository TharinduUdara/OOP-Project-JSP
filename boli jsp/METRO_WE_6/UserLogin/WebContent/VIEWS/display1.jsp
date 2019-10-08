<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Display</title>

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
<%
	String p_payID = (String)request.getAttribute("payID");
	String p_memID = (String)request.getAttribute("memID");
	String p_payFor = (String)request.getAttribute("payFor");
	String p_payMe = (String)request.getAttribute("payMe");
	String p_cardNum = (String)request.getAttribute("cardNum");
	String p_bank = (String)request.getAttribute("bank");
	String p_amount = (String)request.getAttribute("amount");
	
%>

	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
	
			
				<form method = "post" action = "" class = "form" name = "form" class="login100-form validate-form">
				
						<br/><br/>
						<span class="login100-form-title p-b-37">
								Display
						</span>
						
						
							
								<table style="background: #f5f5f5; border-collapse: separate;box-shadow: inset 0 1px 0 #fff;font-size: 12px;line-height: 24px;margin: 30px auto;text-align: left;width: 800px;" border = "1">
								  <h2>Payment</h2>
								  <tr>
								    <th>Pay ID</th>
								    <th>Mem ID</th>
								    <th>Pay For</th>
								    <th>Pay method</th>
								    <th>Card No</th>
								    <th>Bank</th>
								    <th>Amount</th>
								  </tr>
								  <tr>
								    <td><%=p_payID%></td>
								    <td><%=p_memID%></td>
								    <td><%=p_payFor%></td>
								    <td><%=p_payMe%></td>
								    <td><%=p_cardNum%></td>
								    <td><%=p_bank%></td>
								    <td><%=p_amount%></td>
								  </tr>
								</table>
								
								
								
						
					
				</form>
		
	</div>

</body>
</html>