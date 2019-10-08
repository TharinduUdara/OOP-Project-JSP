<!-- @author vidula IT18026962 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register Student</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script>
  
  
  function validateform(){  
	  var Firstname=document.myform.firstName.value; 
	  var Lastname=document.myform.lastName.value; 
	  var parent=document.myform.parent_guardian.value;
	  var dob=document.myform.DOB.value;
	  var classes=document.myform.classes.value;
	  var username=document.myform.userName.value;  
	  var password=document.myform.password.value;  
	    
	  if (Firstname==null || Firstname==""){  
	    alert("First Name can't be blank");  
	    return false;  
	  }else if(Lastname==null || Lastname==""){
		  alert("Last Name can't be blank");  
		    return false;  
		  
	  }
	  else if(parent==null || parent==""){
		  
		  alert("Parent/guardian can't be blank");  
		    return false; 
	  }
 else if(dob==null || dob==""){
		  
		  alert("Date of Birth can't be blank");  
		    return false; 
	  }
 else if(classes==null || classes==""){
	  
	  alert("class can't be blank");  
	    return false; 
 }
 else if(username==null || username==""){
	  
	  alert("Username can't be blank");  
	    return false; 
 }
 else if(password.length<6){
	 alert("Password must be at least 6 characters long.");  
	    return false;  
 }
  }
		  
  
  
  
  
  
  
  </script>
  <style>
   .back{

   	background-image: url("images/school.jpg");
   	background-size: cover;
   	height: 150%;
   	background-position: center;
   	opacity: 0.8

   }


   * {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}



.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
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
<!-- Login Verification code  -->
<%
	String user = (String)session.getAttribute("username");
	if(user == null)
	{
		response.sendRedirect("index.jsp?notlogged=true");
	}
%>
<!-- Login code End -->

  <div class="container-fluid bg-1 text-center back form-group">
	<a href="adminMain.jsp" ><button class="button button2">Back to Home</button></a>
    <h2>Register Student</h2>


<div class="container">
  <form method="POST" action="AddStudentServlet" name="myform" onsubmit="return validateform()">
    <div class="row">
      <div class="col-25">
        <label for="firstName">First Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="firstName" name="firstName" placeholder="Your name..">
      </div>
    </div>


    <div class="row">
      <div class="col-25">
        <label for="lastName">Last Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="lastName" name="lastName" placeholder="Your last name..">
      </div>
    </div>

    <div class="row">
      <div class="col-25">
        <label for="Gender">Gender</label>
      </div>
      <div class="col-75">
        <select id="gender" name="gender">
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>
      </div>
    </div>





   <div class="row">
      <div class="col-25">
        <label for="Address1">Address 1</label>
      </div>
      <div class="col-75">
        <input type="text" id="address1" name="address1" placeholder="Address1..">
      </div>
    </div>

      <div class="row">
      <div class="col-25">
        <label for="Address2">Address 2</label>
      </div>
      <div class="col-75">
        <input type="text" id="address2" name="address2" placeholder="Address2..">
      </div>
    </div>



          <div class="row">
      <div class="col-25">
        <label for="City">City</label>
      </div>
      <div class="col-75">
        <input type="text" id="city" name="city" placeholder="City..">
      </div>
    </div>


              <div class="row">
      <div class="col-25">
        <label for="Parent_guardian">Parent/Guardian</label>
      </div>
      <div class="col-75">
        <input type="text" id="parent_guardian" name="parent_guardian" placeholder="Parent/Guardian..">
      </div>
    </div>


                  <div class="row">
      <div class="col-25">
        <label for="Home Tel">Home Tel</label>
      </div>
      <div class="col-75">
        <input type="text" id="Home Tel" name="homeTelephone" placeholder="Home Tel.." pattern="\d*" title="Use must use only numbers" required>
      </div>
    </div>


                      <div class="row">
      <div class="col-25">
        <label for="Mobile">Mobile</label>
      </div>
      <div class="col-75">
        <input type="text" id="Mobile" name="mobile" size="10" placeholder="Mobile.." pattern="\d*" title="Use must use only numbers">
      </div>
    </div>


                          <div class="row">
      <div class="col-25">
        <label for="dob">DOB</label>
      </div>
      <div class="col-75" align="left">
        <input type="date" id="dob" name="DOB" placeholder="dob.."  value="MM/YYY">
      </div>
    </div>


                          <div class="row">
      <div class="col-25">
        <label for="classes">Class</label>
      </div>
      <div class="col-75">
        <input type="text" id="classes" name="classes" placeholder="Class..">
      </div>
    </div>


                              <div class="row">
      <div class="col-25">
        <label for="Username">Username</label>
      </div>
      <div class="col-75">
        <input type="text" id="Username" name="userName" placeholder="Username..">
      </div>
    </div>




                              <div class="row">
      <div class="col-25">
        <label for="password">Password</label>
      </div>
      <div class="col-75">
        <input type="text" id="password" name="password" placeholder="Password.." pattern="^(?=.*\d)(?=.*(A-Z)(?!.*\s).*$" title="Please include at least 1 uppercase character,1 lowercase character and 1 number" required>
      </div>
    </div>


<input type="submit" class="btn btn-primary btn-lg btn-block" value="Add Student">
<input type="reset" class="btn btn-default btn-lg btn-block" value="Reset">
</form>

<form method="POST" action="ListStudentServlet">

<input type="submit" class="btn btn-success btn-lg btn-block" value="List all students">  
</form>
</div>


  </div>
</body>
</html>