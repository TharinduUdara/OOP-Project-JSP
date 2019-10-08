<%@page import="com.oop.util.DBConnection"%>
<%@page import="com.oop.service.ReminderService"%>
<%@page import="com.oop.service.TeacherService"%>
<%@page import="com.oop.service.StudentService"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.*"%>
<%@page import="com.oop.service.AddExamService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashbord</title>
	<link rel="stylesheet" href="css/bootstrap2.css">
	<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
	<body>
	<nav class="navbar navbar-dark bg-dark text-light ">
 		 <a class="navbar-brand">School Managment System</a>
  			<form class="form-inline">
    			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    			<li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
  			</form>
	</nav>
<div class="container-fluid  card-group"> 

	<div class="container-fluid left-top-tablewindow card  card-group">
		 	<div class="card  bg-light mb-3" style="width:100%;height:100%;">
 					<div class="card-header">
 							<form class="form-inline" method="POST" action="SearchStudentServlet">
 							<div class="input-group-sm mb-3 input-group">	
    							<input class="form-control mr-sm-2 " required="required"  type="search" name="Student_input" placeholder="Search Student" aria-label="Search">
    							<select class="custom-select " id="inputGroupSelect02" name="Student_type">
    								<option selected>Choose...</option>
    								<option value="firstName">Name</option>
   									<option value="memberID">ID</option>
  									<option value="gende">Gender</option>
  									<option value="HomeTelephone">TellNumber</option>
  									<option value="city">City</option>
   									
 								 </select>
    							<button class="btn btn-outline-success my-2 my-sm-0 btn-sm" style="margin-left: 1%;  type="submit" name="Student_button">Search</button>
    						</div>		
  							</form>
 					 </div>
 					<div class="card-body">
 					<div style="height: 198px; overflow: scroll;">
 						<table class=" table table-sm table-active" style="font-size: 12px;">
							<thead class=" bg-primary">
								<tr >
									<th>Student ID</th>
									<th>FName</th>
									<th>Grade</th>
									<th>City</th>
									<th>TellNum</th>
									
									
								</tr>
							</thead>
							 
								<tbody  style=" height: 10px; overflow: scroll;">
								
								<%
								
								
								
		try{
			ResultSet rest=null;
			  rest= (ResultSet)request.getAttribute("SerchResultStudent"); 
			 if(rest==null){
				 StudentService getData=new StudentService();
				  rest=  getData.getTable();	
			 }
									
			
			while(rest.next()){ %>
			<tr>	
				<td><%=rest.getString(1) %></td>
				<td><%=rest.getString(2) %></td>
				<td><%=rest.getString(3) %> </td>
				<td><%=rest.getString(4) %> </td>
				<td><%=rest.getString(5) %> </td>
				
				
			</tr>	
				
				
				
			<% }
				
			
			
		}catch(Exception ex){
			out.print("Exseption is :"+ex);
		}
		
				
		
		%>
		
																
								
									</div>
								</tbody>
							 
						</table>
   						</div >
  					</div>
			</div>
 	  
	</div>

	<div class="container-fluid right-top-tablewindow">

		<div class="card bg-light mb-3" style="width:100%;height: 100%;">
 					  <div class="card-header">
 					  		
 						<form class="form-inline" method="POST" action="ReminderServlet">
 							<div class="input-group-sm mb-3 input-group">
    							<input class="form-control mr-sm-2"   type="search" placeholder="Search" aria-label="Search Class" name="reminder_text">
    							<select class="custom-select" id="inputGroupSelect02"  name="reminder_type">
    								<option selected>Choose...</option>
   									<option value="reminder">Reminder</option>
  									<option value="date_time">Date</option>
  									
 								 </select>
    							<button type="submit" class="btn btn-outline-success my-2 my-sm-0 btn-sm" style="margin-left: 1%" value="searchReminder"  name="reminderBtn">Search</button>
    							 <button type="submit" class="btn btn-primary my-sm-0 btn-sm" style="margin-left:1%" value="addnew" name="reminderBtn">Add Reminder</button>
  							</form>
  						</div>
 					 </div>
  					<div class="card-body">
  					<div style="height: 198px; overflow: scroll;">
  							<table class=" table table-sm table-active" style="font-size: 12px;">
							<thead class=" bg-primary">
								<tr >
									<th>Reminder ID</th>
									<th>Reminder</th>
									<th>Date</th>
									<th>Action</th>
									
								</tr>
							</thead>
							 
								<tbody  style=" height: 10px; overflow: scroll;">
								
								<%
		try{
			ResultSet restcls=null;
			restcls= (ResultSet)request.getAttribute("SerchResultRimnder"); 
			 if(restcls==null){
				 ReminderService getData=new ReminderService();
				  restcls=  getData.getTable();
			 }
			
			
			
				
			
			
			while(restcls.next()){ %>
			<tr>	
				<td><%=restcls.getString(1) %></td>
				<td><%=restcls.getString(2) %></td>
				<td><%=restcls.getString(3) %> </td>
				<td>
				<form method="post" action="DeleteReminder">
					<input type="text" name="remiderID" value=<%=restcls.getString(1)%> hidden>
					<input type="submit" name="deleteReminderBtn" class="btn btn-outline-danger btn-sm" value="Delete">
								
				</form>
				</td>
				
			</tr>	
				
				
				
			<% }
			
			
			
			
		}catch(Exception ex){
			
			out.print("Exseption is :"+ex);
		}
		
		
		
		
		
		%>	
									
								
									
							</div>
								</tbody>
							 
						</table>

   				  
  				</div>
  						
  					</div>
			</div>
  
	</div>

	<div class="container-fluid left-bottom-tablewindow  card-group ">
		<div class="card bg-light mb-3" style="width:100%;height: 100%;">
 					 <div class="card-header">
 					 	<h5 >Featured</h5>

 					 </div>
  				<div class="card-body">
  				 <div class="container-fluid profle-image-box">
  				<% 
  				
  				String userName = (String) session.getAttribute("username");
  				//String teacherID="teacher";
  				TeacherService getTeacherData=new TeacherService();
  				ResultSet getTeacherDataResultste=getTeacherData.getTable(userName);
  				
  				try{
  					
  					while(getTeacherDataResultste.next()){%>
  						
  						
 					 				<img src="images/teacher.jpg"  class="img-thumbnail profle-image" style="height: 100px;">
 					 				<p class="text-center font-weight-bolder"> <%=getTeacherDataResultste.getString(2) %> </p>
 								 </div>
 					 		
 					 		
 					 			<div class="container-fluid profile-detail-box">
 					 				<p class="text-left font-weight-light">Name :<%=getTeacherDataResultste.getString(2) %></p>
 					 				<p class="text-left font-weight-light">Gender :<%=getTeacherDataResultste.getString(4) %></p>
 					 				<p class="text-left font-weight-light">Dob :<%=getTeacherDataResultste.getString("DOB") %></p>
 					 				<p class="text-left font-weight-light">Telnumber :<%=getTeacherDataResultste.getString("HomeTelephone") %></p>
 					 				<p class="text-left font-weight-light">City :<%=getTeacherDataResultste.getString("city") %></p>
 							 	</div>	
  						
  											
  						  						
  						
  				<%	}	
  					  					
  					
  				}catch(Exception ex){
  					
  					System.out.println(ex);
  				}
  				  							
  				  				  				  				
  				
  				%>
  				 				
  							 		 					 		
  				   				  
  				</div>
			</div>
  
	</div>

	<div class="container-fluid right-bottom-tablewindow">
		<div class="card bg-light mb-3" style="width:100%;height: 100%;">
 					 <div class="card-header">
 					 	
 							<form class="form-inline" method="POST" action="SearchExamServlet">
 								<div class="input-group-sm mb-3 input-group">	
    								<input class="form-control mr-sm-2" type="search" placeholder="Search Exams" required="required" aria-label="Search"  name="Exam_Search_text">
    							
    								<select class="custom-select" id="inputGroupSelect02"  name="Exam_select">
    									<option selected>Choose...</option>
   										<option value="examName">Name</option>
  										<option value="examLocation">Location</option>
   										<option value="examGrade">Grade</option>
   										<option value="examSubject">Subject</option>
 								 </select>
 								 <button class="btn btn-outline-success my-2 my-sm-0 btn-sm" type="submit" style="height: 30px; margin-left: 1%" value="search"  name="examBtn">Search</button>
    							</form>
    						<form class="form-inline" method="POST" action="ExamServlet">
    							 <button type="submit" class="btn btn-primary my-sm-0 btn-sm" style="height: 30px; margin-left:1%" value="addnew" name="examBtn">Add </button>
  							  
  							</form>
 					 </div>
 					</div> 
  				<div class="card-body">
  				<div style="height: 198px; overflow: scroll;">
  							<table class=" table table-sm table-active" style="font-size: 12px;">
							<thead class=" bg-primary">
								<tr >
									<th>ID</th>
									<th>Name</th>
									<th>Subject</th>
									<th>Grade</th>
									<th>Location</th>
									<th>Action</th>
									
								</tr>
							</thead>
							 
								<tbody  style=" height: 10px; overflow: scroll;">
								
								<%
		try{
			
			 
			 
			 	
			ResultSet rest=null;
			  rest= (ResultSet)request.getAttribute("SerchResult"); 
			 if(rest==null){
				 AddExamService getData=new AddExamService();
				  rest=  getData.getTable();
			 }
			
			while(rest.next()){ %>
			<tr>	
				<td><%=rest.getString(1) %></td>
				<td><%=rest.getString(2) %></td>
				<td><%=rest.getString(3) %> </td>
				<td><%=rest.getString(4) %> </td>
				<td><%=rest.getString(5) %> </td>
				<td>
				<form method="post" action="EditExamServlet">
					<input type="text" name="examID" value=<%=rest.getString(1)%> hidden>
					<input type="submit" name="editexamsubmit" class="btn btn-outline-warning btn-sm" value="Edite">
								
				</form>
				</td>
			</tr>	
				
				
				
			<% }
			
			
			
			
		}catch(Exception ex){
			out.print("Exseption is :"+ex);
		}
		
		
		
		
		
		%>
	</div>
								</tbody>
							 
						</table>

   				  
  				</div>
			</div>
  
	</div>
 
</div>

</body>
</html>