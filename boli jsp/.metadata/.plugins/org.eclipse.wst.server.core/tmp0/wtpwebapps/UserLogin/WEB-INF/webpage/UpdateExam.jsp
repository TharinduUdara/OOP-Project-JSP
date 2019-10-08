<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
 <%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.*"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<link rel="stylesheet" href="css/bootstrap.css">
	<title>Update exam</title>
	
</head>
<body>
<br></br>
<br></br>


<div class="container-fluid" style="width: fit-content;">
<%

	String examId=(String)request.getAttribute("examId");
	String examName=(String)request.getAttribute("examName");
	String examGrade=(String)request.getAttribute("examGrade");
	String examSubject=(String)request.getAttribute("examSubject");
	String examLocation=(String)request.getAttribute("examLocation");


%>
	<h3>Edite Exam</h3>
 <form method="post" action="UpdateExamServerlet">
 	 <div class="form-row">
    	<div class="form-group col-md-6">
   	   <label for="inputEmail4">Exam Name</label>
    	  <input type="text" class="form-control" id="inputEmail4" placeholder="Exam Name" maxlength="20" name="examName" value="<%=examName%>">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Exam ID</label>
      
      <input type="text" class="form-control" id="inputPassword4" required="required" maxlength="20" placeholder="Exam ID " disabled="disabled" name="examId"value="<%=examId%>">
 		<input type="text" name="examID" value="<%=examId%>" hidden>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Subject</label>
    <input type="text" class="form-control" id="inputAddress" required="required" maxlength="20" placeholder="Subject Name" name="examSubject" value="<%=examSubject%>">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Grade</label>
    <input type="text" class="form-control" id="inputAddress2" required="required" maxlength="20" placeholder="Grade" name="examGrade" value="<%=examGrade%>">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Location</label>
    <input type="text" class="form-control" id="inputAddress2"  required="required" maxlength="20" placeholder="Location" name="examLocation" value="<%=examLocation%>">
  </div>

      <button type="submit" class="btn btn-primary btn-block" value="update" name="examButton">Update</button>
      <button type="submit" class="btn btn-warning btn-block" value="delete" name="examButton">Delete</button>
   </form>   
      <button  class="btn btn-danger btn-block" value="cancel" name="examButton" onclick="closeWindow()">Cancel</button>
	 
	 <script type="text/javascript">
	 	function closeWindow(){
	 		
          window.location = '/TeacherDashbord';

     
	 	}	
	 
	 </script>
    
  </div>
  
  




</div>

</body>
</html>