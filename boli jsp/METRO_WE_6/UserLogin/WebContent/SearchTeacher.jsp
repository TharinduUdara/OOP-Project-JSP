<!-- @author B.M.A.T Udara IT17373012  -->
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Teacher</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css" href="/Member/table.css">
<style>
body {
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
</style>
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
<p style="text-align:center;">Search Teacher</p>
<form class="example" method="post" action="searchTeacher">
  <input type="text" placeholder="Search.." name="search">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>

<table border="1" cellpadding="12">
		 
		  <tr>
                <th>Member ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address1</th>
                <th>Address2</th>
                <th>City</th>
                <th>Gender</th>
                <th>Home Telephone</th>
                <th>Mobile</th>
                <th>DOB</th>
                <th>UserName</th>
                <th>Password</th>
                <th>NIC</th>
                <th>Representing Class</th>
                
            </tr>
            
            <%
            
            try{
            	
            	ResultSet rs1=(ResultSet)request.getAttribute("result");
            	
            	while(rs1.next()){ %>
            		
            	<tr>	<td><%=rs1.getString(1) %></td>
            		<td><%=rs1.getString(2) %></td>
            		<td><%=rs1.getString(3) %></td>
            		<td><%=rs1.getString(4) %></td>
            		<td><%=rs1.getString(5) %></td>
            		<td><%=rs1.getString(6) %></td>
            		<td><%=rs1.getString(7) %></td>
            		<td><%=rs1.getString(8) %></td>
            		<td><%=rs1.getString(9) %></td>
            		<td><%=rs1.getString(10) %></td>
            		<td><%=rs1.getString(11) %></td>
            		<td><%=rs1.getString(12) %></td>
            		<td><%=rs1.getString(13) %></td>
            		<td><%=rs1.getString(14) %></td>
            		
            	</tr>	
            		
            		
            	<%}
            	
            	
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            
            
           %> 
            
            
         </table>
            


</body>
</html>