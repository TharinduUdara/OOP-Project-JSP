package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		try{
			// get username and password
	        String username = request.getParameter("username");   
	        String password = request.getParameter("password");
	        
	       char prefix = username.charAt(0);
	       
	       String sqlStatement="";
	       String redirect="";
	       if(username.matches("admin"))
	       {
	    	   sqlStatement = "Select username,password from admin where username=? and password=?";
	    	   redirect="adminMain.jsp";
	       }
	       else if(username.matches("cashier"))
	       {
	    	   sqlStatement = "Select username,password from admin where username=? and password=?";
	    	   redirect="cashier.jsp";
	       }
	       else if(prefix == 't' || prefix == 'T')
	       {
	    	   sqlStatement = "Select username,password from teacher where teacherID=? and password=?";
	    	   redirect="Teacherdashbord.jsp";
	    	  // username = username.toUpperCase();
	       }
	       else if(prefix == 's' || prefix == 'S')
	       {
	    	   sqlStatement = "Select username,password from student where memberID=? and password=?";
	    	   redirect="MemberStudent.jsp";
	    	   username = username.toUpperCase();	    	   
	       }
	       
	        
	        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
	        
	        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "");
	        Connection conn = DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
		        	
	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
	        PreparedStatement pst = conn.prepareStatement(sqlStatement);
	        
	        pst.setString(1, username);
	        pst.setString(2, password);
	        ResultSet rs = pst.executeQuery();     
	        
	        if(rs.next()) {
	        	HttpSession session = request.getSession();
	        	session.setAttribute("username", username);
	        	response.sendRedirect(redirect);
	        }
	        else {
	           response.sendRedirect("index.jsp?error=AuthFailed");
	        }
	   }
	   catch(Exception e){       
	       out.println("Something went wrong !! Please try again "+e.getMessage());       
	   }   
		
		
	}

}
