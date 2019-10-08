<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<link rel="stylesheet" href="css/bootstrap.css">
	<title>Add new Reminder</title>
</head>
<body>
<br></br>
<br></br>

<div class="container-fluid" style="width: fit-content;">
	<h3>Add New Reminder</h3>
 <form method="post" action="AddReminderServlet">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Reminder Date</label>
      <input type="date" class="form-control" id="inputEmail4" required="required" placeholder="Reminder Date" name="reminderDate">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Reminder ID</label>
      
      <input type="text" class="form-control" id="inputPassword4"  maxlength="20" placeholder="Exam ID auto generator " name="ReminderID" disabled="disabled">
 
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Reminder me to...</label>
    <textarea type="text" class="form-control" id="inputAddress"  maxlength="140" required="required" placeholder="Reminder me to" name="Reminder"></textarea>
  </div>
  

      <button type="submit" class="btn btn-primary btn-block"   value="save" name="ReminderButton">Save</button>
     
  </form> 
  		<p></p>   
      <button type="submit" class="btn btn-danger btn-block" value="cancel" name="examButton" onclick="closeButton()" >Cancel</button>
	 
	
    
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