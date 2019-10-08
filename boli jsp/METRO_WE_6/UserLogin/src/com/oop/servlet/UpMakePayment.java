package com.oop.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Payment;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;

/**
 * Servlet implementation class UpMakePayment
 */
@WebServlet("/UpMakePayment")
public class UpMakePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpMakePayment() {
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
		String myDriver = "com.mysql.jdbc.Driver";
		String myURL = "jdbc:mysql://localhost:3306/school";
		
		try {
			
			Payment p1 = new Payment();
			
			p1.setMemberID(request.getParameter("userID"));
			
			Class.forName(myDriver);
			
			java.sql.Connection con =DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
			
			PreparedStatement ps = con.prepareStatement("select * from student where memberID = '"+p1.getMemberID()+"'"); //where uname = '\"+user1.getUname()+\"'\
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			if(rs.getString(1).equals(p1.getMemberID()))
			{
						String message = "Successful!!!!";
						request.setAttribute("message", message);
						
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/VIEWS/UpMakePayment2.jsp");
						rd.forward(request, response);
			}
			
			con.close();
		
				
		}
				catch(Exception e)
				{
					String message = "Unsuccessful, enter Again";
					request.setAttribute("message", message);
					
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/VIEWS/MakePayment.jsp");
					rd.forward(request, response);
					
					System.out.println("Exception is occured");
					System.out.println(e.getMessage());
				}
		
					finally
					{
						
					}
		
	}

}
