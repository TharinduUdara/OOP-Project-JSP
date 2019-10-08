package com.oop.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
 * Servlet implementation class UpMakePayment2
 */
@WebServlet("/UpMakePayment2")
public class UpMakePayment2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpMakePayment2() {
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
		
		Payment p1 = new Payment();
		
		try {
			
			p1.setMemberID(request.getParameter("memID"));
			
			p1.setFee(Double.parseDouble(request.getParameter("fee")));
			
			p1.setExCur(Double.parseDouble(request.getParameter("exCur")));
			
			p1.setAdditional(Double.parseDouble(request.getParameter("add")));
			
			Class.forName(myDriver);
			
			java.sql.Connection con =DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
			
			PreparedStatement ps = con.prepareStatement("insert into tobepaid values('"+p1.getMemberID()+"', '"+p1.getFee()+"' , '"+p1.getExCur()+"', '"+p1.getAdditional()+"')");
			
			ps.execute();
		      
		    con.close();
		    
		    RequestDispatcher rd1 = request.getRequestDispatcher("/VIEWS/PayDisplay.jsp");
			rd1.forward(request, response);
		    
			}
		
				catch(Exception e)
				{
					System.out.println("Exception is occured");
					System.out.println(e.getMessage());
				}
		
					finally
					{
						
					}
	}

}
