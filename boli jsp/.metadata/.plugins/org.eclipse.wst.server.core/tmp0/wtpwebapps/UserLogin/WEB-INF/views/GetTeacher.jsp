<!-- @author vidula IT18026962 -->
<%@page import="com.oop.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Theme Simply Me</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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


  </style> 



</head>
<body>

  <div class="container-fluid bg-1 text-center back form-group" >

    <h2>Manage Teacher</h2>
    
    <% Teacher teacher=(Teacher) request.getAttribute("teacher"); %>


<div class="container">
  <form method="POST" action="UpdateTeacherServlet">
  
  
  
     <div class="row">
      <div class="col-25">
        <label for="teacherID">TeacherID</label>
      </div>
      <div class="col-75">
        <input type="text" id="teacherID" name="teacherID" placeholder="Your name.." disabled="disabled" value="<%=teacher.getMemberID() %>" >
      </div>
    </div>
  
  
  
  
  
    <div class="row">
      <div class="col-25">
        <label for="firstName">First Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="firstName" name="firstName" placeholder="Your name.." value="<%=teacher.getFirstName()%>">
      </div>
    </div>


    <div class="row">
      <div class="col-25">
        <label for="lname">Last Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="lname" name="lastName" placeholder="Your last name.."  value="<%=teacher.getLastName()%>">
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
        <input type="text" id="address1" name="address1" placeholder="Address1.."  value="<%=teacher.getAddress1()%>" />
      </div>
    </div>

      <div class="row">
      <div class="col-25">
        <label for="Address2">Address 2</label>
      </div>
      <div class="col-75">
        <input type="text" id="address2" name="address2" placeholder="Address2.."  value="<%=teacher.getAddress2()%>" />
      </div>
    </div>



          <div class="row">
      <div class="col-25">
        <label for="City">City</label>
      </div>
      <div class="col-75">
        <input type="text" id="city" name="city" placeholder="City.." value="<%=teacher.getCity()%>">
      </div>
    </div>



                  <div class="row">
      <div class="col-25">
        <label for="Home Tel">Home Tel</label>
      </div>
      <div class="col-75">
        <input type="text" id="Home Tel" name="homeTelephone" placeholder="Home Tel.." value="<%=teacher.getHomeTelephone()%>">
      </div>
    </div>


                      <div class="row">
      <div class="col-25">
        <label for="Mobile">Mobile</label>
      </div>
      <div class="col-75">
        <input type="text" id="Mobile" name="mobile" size="10" placeholder="Mobile.." value="<%=teacher.getMobile()%>">
      </div>
    </div>


                          <div class="row">
      <div class="col-25">
        <label for="dob">DOB</label>
      </div>
      <div class="col-75" align="left">
        <input type="date" id="dob" name="DOB" placeholder="dob.."  value="MM/YYY" value="<%=teacher.getDOB()%>">
      </div>
    </div>


                              <div class="row">
      <div class="col-25">
        <label for="Username">Username</label>
      </div>
      <div class="col-75">
        <input type="text" id="Username" name="userName" placeholder="Username.."  value="<%=teacher.getUserName()%>">
      </div>
    </div>




                              <div class="row">
      <div class="col-25">
        <label for="Password">Password</label>
      </div>
      <div class="col-75">
        <input type="text" id="Password" name="password" placeholder="Password.." value="<%=teacher.getPassword()%>">
      </div>
      </div>
      
      
          
                   <div class="row">
      <div class="col-25">
        <label for="NIC">NIC</label>
      </div>
      <div class="col-75">
        <input type="text" id="NIC" name="NIC" placeholder="NIC.." value="<%=teacher.getNIC() %>">
      </div>
    </div>
    
    
    
                 <div class="row">
      <div class="col-25">
        <label for="rClass">representing class</label>
      </div>
      <div class="col-75">
        <input type="text" id="rClass" name="rClass" placeholder="representing class.." value="<%=teacher.getrClass() %>">
      </div>
    </div>
      
      
      
    
    
    <div>
    <input type="hidden" name="memberID"
					value="<%=teacher.getMemberID()%>" /> 
    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Update Teacher"/>
    </div>
 
</form>

<form method="POST" action="DeleteTeacherServlet">
<div>
<input type="hidden" name="memberID"
						value="<%=teacher.getMemberID()%>" />
<input type="submit" class="btn btn-success btn-lg btn-block" value="Delete Teacher">  
</div>
</form>

</div>

</div>


</body>
</html>