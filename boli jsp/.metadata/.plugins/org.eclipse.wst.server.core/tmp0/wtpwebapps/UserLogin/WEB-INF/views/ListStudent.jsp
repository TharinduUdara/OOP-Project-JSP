<!-- @author vidula IT18026962 -->
<%@page import="com.oop.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.StudentServiceImpl"%>
<%@page import="com.oop.service.IStudentService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html lang="en">
<head>
  <title>The Student List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/Member/table.css">

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

    <h2>Manage Student</h2>

    <a href="/UserLogin/Search.jsp"><button class="button button2" style="background-color: #8960E0;">Want to Search student ?</button></a>
    <a href="MemberStudent.jsp"><button class="button button2">Want to Add student ?</button></a>
    <br>
    <table border="1" cellpadding="12">
		 <caption>  <h2>List of Student</h2></caption>
		 <thead>
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
                <th>Select</th>
            </tr>
            </thead>
            <%
            IStudentService iStudentService = new StudentServiceImpl();
			ArrayList<Student> arrayList = iStudentService.getStudent();
			
			for(Student student : arrayList){
			%>
			 <tr>
				<td> <%=student.getMemberID() %> </td>
				<td> <%=student.getFirstName() %> </td>
				<td> <%=student.getLastName() %> </td>
				<td> <%=student.getAddress1() %> </td>
				<td> <%=student.getAddress2() %> </td>
				<td> <%=student.getCity() %> </td>
				<td> <%=student.getParent_guardian() %> </td>
				<td> <%=student.getGender() %> </td>
				<td> <%=student.getHomeTelephone()%></td>
				<td> <%=student.getMobile()%></td>
				<td><%=student.getDOB()%></td>
				<td><%=student.getClasses()%></td>
				<td><%=student.getUserName()%></td>
				<td><%=student.getPassword()%></td>
				<td> 
				<form method="POST" action="GetStudentServlet">
				<input type="hidden" name="memberID" value="<%=student.getMemberID()%>"/>
				 <input type="submit" value= "Select Student"  /> 
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