<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<link rel="stylesheet" href="css/bootstrap.css">
	<title>Add new exam</title>
</head>
<body>
<br></br>
<br></br>

<div class="container-fluid" style="width: fit-content;">
	<h3>Add New Exam</h3>
 <form method="post" action="AddExam">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Exam Name</label>
      <input type="text" class="form-control" id="inputEmail4" required="required" placeholder="Exam Name" name="examName">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Exam ID</label>
      
      <input type="text" class="form-control" id="inputPassword4"  maxlength="20" placeholder="Exam ID auto generator " name="examID" disabled="disabled">
 
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Subject</label>
    <input type="text" class="form-control" id="inputAddress"  maxlength="20" required="required" placeholder="Subject Name" name="examSubject">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Grade</label>
    <input type="text" class="form-control" id="inputAddress2"  maxlength="20" required="required" placeholder="Grade" name="examGrade">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Location</label>
    <input type="text" class="form-control" id="inputAddress2"  maxlength="20" required="required" placeholder="Location" name="examLocation">
  </div>

      <button type="submit" class="btn btn-primary btn-block"  maxlength="20" value="save" name="examButton">Save</button>
     
  </form> 
  		<p></p>   
      <button type="submit" class="btn btn-danger btn-block" value="cancel" name="examButton" onclick="closeButton()">Cancel</button>
	 
	
    
  </div>
  <script type="text/javascript" language="JavaScript">
                  function closeButton()
            {

                window.location = '/UserLogin/Teacherdashbord.jsp';

            }
   </script>
  




</div>

</body>
</html>