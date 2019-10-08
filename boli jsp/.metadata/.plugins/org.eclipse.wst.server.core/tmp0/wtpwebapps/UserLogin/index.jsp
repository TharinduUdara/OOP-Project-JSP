
<%@page import="com.oop.util.CommonConstants" %>
<%@page import="com.oop.util.CommonUtil" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="css/loginstyles.css">
<title>Welcome</title>
</head>
<body>
<div id="overlay"></div>
    <div class="login-box">
        <h1>Login</h1>
        
    <form name="login-form" action="LoginServlet" method="POST" onsubmit="return ValidateForm()">

        
        	<%
        		String error = null;
        		String notlogged = null;
        		String loggedout = null;
        		error = request.getParameter("error");
        		notlogged = request.getParameter("notlogged");
        		loggedout = request.getParameter("loggedout");
        		if(error != null)
        		{
        			out.println("<div id=\"error\" class=\"error\">");
        			out.println("Username or Password is wrong!");
        			out.println("</div>");
        		}
        		else if(notlogged != null){
        			out.println("<div id=\"error\" class=\"error\">");
        			out.println("Please login to enter!");
        			out.println("</div>");
        		}
        		else if(loggedout != null){
        			out.println("<div id=\"error\" class=\"success\">");
        			out.println("Logged out successfully!");
        			out.println("</div>");
        		}
        		else{
        			out.println("<div id=\"error\"></div>");	
        		}
        		
        	%>
        
            
        <div class="text-box">
            <i class="fa fa-user" aria-hidden="true"></i>
            <input type="text" placeholder="Username" name="username" maxlength="10" required>
        </div>

        <div class="text-box">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Password" name="password" maxlength="10" required>
        </div>

        <input type="submit" value="Login" class="login-btn">
    </form>
    </div>
<script src="js/script.js"></script>


<%@ page import ="java.sql.*" %>
<%
	
	
	Connection connection = null;
    Statement statement = null;
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        /**connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/",
                "root", "");*/
                connection= DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
    	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
                
        statement = connection.createStatement();
        String sql = "CREATE DATABASE IF NOT EXISTS school";
        statement.executeUpdate(sql);
        //System.out.println("Database created!");
    } catch (SQLException sqlException) {
        if (sqlException.getErrorCode() == 1007) {
            // Database already exists error
            System.out.println(sqlException.getMessage());
        } else {
            // Some other problems, e.g. Server down, no permission, etc
            sqlException.printStackTrace();
        }
    } catch (ClassNotFoundException e) {
        // No driver class found!
    }
    
    
    try {
    	//Class.forName("com.mysql.jdbc.Driver");
    	/*connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "");*/
    	connection= DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
    	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
    	statement = connection.createStatement();
    	String query = "CREATE TABLE IF NOT EXISTS student(memberID varchar(10) not null,firstName varchar(20),lastName varchar(20),gender varchar(10) DEFAULT 'Male',address1 varchar(20),"
    			+"address2 varchar(20),"
    			+"city varchar(20),"
    			+"parent_guardian varchar(20),"
    			+"HomeTelephone varchar(10),"
    			+"mobile varchar(10),"
    			+"DOB varchar(20),"
    			+"classes varchar(10),"
    			+"userName varchar(20) not null,"
    			+"password varchar(32) not null,"
    			+"primary key (memberID));";
    	statement.executeUpdate(query);
    	
    	query = "CREATE TABLE IF NOT EXISTS teacher("
    			+"teacherID varchar(10) not null,"
    			+"firstName varchar(20),"
    			+"lastName varchar(20),"
    			+"gender varchar(10) DEFAULT 'Male',"
    			+"address1 varchar(20),"
    			+"address2 varchar(20),"
    			+"city varchar(20),"
    			+"HomeTelephone varchar(10),"
    			+"mobile varchar(10),"
    			+"DOB varchar(20),"
    			+"userName varchar(20),"
    			+"password varchar(32),"
    			+"NIC varchar(20),"
    			+"rClass varchar(10),"
    			+"primary key (teacherID));";
    	
    	statement.executeUpdate(query);
    	
    	
    	query = "CREATE TABLE IF NOT EXISTS admin(username varchar(10), password varchar(10), primary key (username));";
    	statement.executeUpdate(query);
    	
    	query = "INSERT INTO admin(username,password) values('admin','admin');";
    	statement.executeUpdate(query);
        
    	query = "INSERT INTO admin(username,password) values('cashier','cashier');";
    	statement.executeUpdate(query);
        
    	} 
    	catch (Exception e) 
    	{
    		//out.println("<h1>An error occurred. "+ e.getMessage() +"</h1>");
    	}
    
    connection.close();
%>    
</body>
</html>