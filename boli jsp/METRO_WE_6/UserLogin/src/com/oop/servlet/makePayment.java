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

import java.io.PrintWriter;


import com.oop.model.Payment;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
/**
 * Servlet implementation class makePayment
 */
@WebServlet("/makePayment")
public class makePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makePayment() {
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
			
			PreparedStatement ps1 = con.prepareStatement("select max(payID) from Payment "); //where uname = '\"+user1.getUname()+\"'\
			
			ResultSet rs1 = ps1.executeQuery();
			
			rs1.next();
			
			int pay_count = rs1.getInt(1) + 1;
	
			if(rs.getString(1).equals(p1.getMemberID()))
			{
						String message = "UserID verified!!";
						request.setAttribute("message", message);
						
						request.setAttribute("pay_count", pay_count);
						
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/VIEWS/MakePayment2.jsp");
						rd.forward(request, response);
			}
			
			con.close();
		
				
		}
				catch(Exception e)
				{
					String message = "Unsuccessful, Enter again!!";
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
