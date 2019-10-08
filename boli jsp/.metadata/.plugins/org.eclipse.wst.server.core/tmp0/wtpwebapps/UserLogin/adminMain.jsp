<!-- @author vidula IT18026962 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Admin Dashboard</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">  
  <link rel="stylesheet" type="text/css" href="css/MemberStylesheet.css">
  <link rel="stylesheet" href="css/bootstrap4.css" >
 
  <script  src="js/bootstrap5.js"></script>
  <script  src="js/jquery1.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
  
   <script src="js/bootstrap.min.js"></script>
  
  <style>
   .back{

   	background-image: url("images/school.jpg");
   	background-size: cover;
   	height: 400px;
   	background-position: center;
   	opacity: 0.8

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


<% //Student student=(Student) request.getAttribute("student");
//Student student=new Student();%>

  

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">British College Colombo</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    
      
           <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Add Members
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="MemberStudent.jsp">Add Student</a></li>
          <li><a href="MemberTeacher.jsp">Add Teacher</a></li>
        </ul>
      </li>
      
           <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Search Members
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="Search.jsp">Search Student</a></li>
          <li><a href="SearchTeacher.jsp">Search Teacher</a></li>
        </ul>
      </li>
      
    </ul>
  
    
     <form class="navbar-form navbar-left" method="POST" action="GetStudentByNameServlet">
      <div class="input-group">


        <input type="text" name="firstName"  class="form-control" placeholder="Search" name="search">
        
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>


    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>









<div class="container-fluid bg-1 text-center back">

  <img src="images/admin.jpg" class="img-responsive img-circle" style="display:inline" alt="Admin">
  <h3 style="font-weight: 1000">School Management System Admin</h3>
</div>

<div class="container-fluid bg-3 text-center"> 
  <h3> Member management</h3>
  <div class="row">
    <div class="col-sm-4">
     	<a href ="MemberStudent.jsp"><input type="button" value="Student" class="btn btn-default btn-lg"><br> </a>
      <img src="images/student.jpg" class="img-responsive" style="width:100%;height:50%" alt="Image">
    </div>

    <div class="col-sm-4">
     <a href="MemberTeacher.jsp"> <input type="button" value="Teacher" class="btn btn-default btn-lg"></a>
      <img src="images/teacher.jpg" class="img-responsive" style="width:100%;height:50%" alt="Image">
    </div>
    <div class="col-sm-4"> 
     <a href=""><input type="button" value="other" class="btn btn-default btn-lg"></a>
      <img src="images/Cashier.jpg" class="img-responsive" style="width:100%;height:30%" alt="Image">
    </div>
  </div>
</div>

<footer class="container-fluid bg-4 text-center">
  <p>@2018 copyright: <a href="https://www.w3schools.com">British College Colombo</a></p> 
</footer>

</body>
</html>