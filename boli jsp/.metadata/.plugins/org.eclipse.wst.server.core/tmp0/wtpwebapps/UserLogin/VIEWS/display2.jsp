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
	
	String p_memID1 = (String)request.getAttribute("memID1");
	double p_fee = (double)request.getAttribute("fee");
	double p_exCu = (double)request.getAttribute("extra");
	double p_add = (double)request.getAttribute("add");
	
%>

	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
	
			
				<form method = "post" action = "" class = "form" name = "form" class="login100-form validate-form">
				
						<br/><br/>
						<span class="login100-form-title p-b-37">
								Display
						</span>
						
						
								
								<table style="background: #f5f5f5; border-collapse: separate;box-shadow: inset 0 1px 0 #fff;font-size: 12px;line-height: 24px;margin: 30px auto;text-align: left;width: 800px;" border = "1">
								
								  <h2>Balance to be paid</h2>
								  <tr>
								    <th>Mem ID</th>
								    <th>Fee</th>
								    <th>Ext Cur</th>
								    <th>Additonal</th>
								  </tr>
								  <tr>
								    <td><%=p_memID1%></td>
								    <td><%=p_fee%></td>
								    <td><%=p_exCu%></td>
								    <td><%=p_add%></td>
								    
								  </tr>
								</table>
								
								
						
					
				</form>
		
	</div>

</body>
</html>