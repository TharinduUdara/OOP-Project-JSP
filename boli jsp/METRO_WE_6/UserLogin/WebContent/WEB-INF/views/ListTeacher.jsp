<!-- @author vidula IT18026962 -->
<%@page import="com.oop.model.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.TeacherServiceImpl"%>
<%@page import="com.oop.service.ITeacherService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html lang="en">
<head>
  <title>List Teacher</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="/UserLogin/css/table.css">
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  float:left;
}

.button2:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}

</style>



</head>
<body>


  <div >

    <h2>Manage Teacher</h2>
    
       <a href="/UserLogin/SearchTeacher.jsp"><button class="button button2" style="background-color: #8960E0;">Want to Search Teacher ?</button></a>
    <a href="MemberTeacher.jsp"><button class="button button2">Want to Add Teacher ?</button></a>
    <br>
    
    <table border="1" cellpadding="12">
		 <caption>  <h2>List of Teachers</h2></caption>
		
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
                <th>Select</th>
            </tr>
            <%
            ITeacherService iteacherService = new TeacherServiceImpl();
			ArrayList<Teacher> arrayList = iteacherService.getTeacher();
			
			for(Teacher teacher : arrayList){
			%>
			 <tr>
				<td> <%=teacher.getMemberID() %> </td>
				<td> <%=teacher.getFirstName() %> </td>
				<td> <%=teacher.getLastName() %> </td>
				<td> <%=teacher.getAddress1() %> </td>
				<td> <%=teacher.getAddress2() %> </td>
				<td> <%=teacher.getCity() %> </td>
				<td> <%=teacher.getGender() %> </td>
				<td> <%=teacher.getHomeTelephone()%></td>
				<td> <%=teacher.getMobile()%></td>
				<td><%=teacher.getDOB()%></td>
				<td><%=teacher.getUserName()%></td>
				<td><%=teacher.getPassword()%></td>
				<td><%=teacher.getNIC() %></td>
				<td><%=teacher.getrClass() %></td>
				<td> 
				<form method="POST" action="GetTeacherServlet">
				<input type="hidden" name="teacherID" value="<%=teacher.getMemberID()%>"/>
				 <input type="submit" value= "Select Teacher"  /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
    
    
    
    </div>
</body>
</html>