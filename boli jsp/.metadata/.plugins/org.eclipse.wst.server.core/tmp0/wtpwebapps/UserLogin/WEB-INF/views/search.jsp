<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="dummy">

<input type="text" name="search">
<input type="submit" value="search">

</form>

<table border="1" cellpadding="12">
		 
		  <tr>
                <th>Member ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address1</th>
                <th>Address2</th>
                <th>City</th>
                <th>Parent_guardian</th>
                <th>Gender</th>
                <th>Home Telephone</th>
                <th>Mobile</th>
                <th>DOB</th>
                <th>Class</th>
                <th>UserName</th>
                <th>Password</th>
                
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