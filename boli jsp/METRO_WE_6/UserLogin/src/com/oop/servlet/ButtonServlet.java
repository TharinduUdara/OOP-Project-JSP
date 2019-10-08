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

import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;



/**
 * Servlet implementation class ButtonServlet
 */
@WebServlet("/ButtonServlet")
public class ButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ButtonServlet() {
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
		
		String CrmakePayment = (request.getParameter("CrMakePayment"));
		String CrupdatePayment = (request.getParameter("CrupdatePayment"));
		String makePayment = (request.getParameter("MakePayment"));
		String UpmakePayment = (request.getParameter("UpMakePayment"));
		String removePayment = (request.getParameter("RemovePayment"));
		String editPayment = (request.getParameter("EditPayment"));
		String fullAmount = (request.getParameter("FullAmount"));
		
		
		if(CrupdatePayment != null)
		{
			String myDriver = "com.mysql.jdbc.Driver";
			String myURL = "jdbc:mysql://localhost:3306/school";
			
			try {
				
				Class.forName(myDriver);
				
				java.sql.Connection con =DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
		        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
		
				PreparedStatement ps = con.prepareStatement("create table toBePaid(memberID varchar(50), Fee double, ExtraCurricular double, Additional double, constraint fk_memberID1 foreign key (memberID) references student(memberID))"); 
				//give the table name according to the registration table in vidula's code
				
				ps.execute();
				
				con.close();
				
				String message = "Welcome";
				request.setAttribute("message", message);
				
				RequestDispatcher rd1 = request.getRequestDispatcher("/VIEWS/UpMakePayment.jsp");
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
		
		else if(CrmakePayment != null)
		{
			String myDriver = "com.mysql.jdbc.Driver";
			String myURL = "jdbc:mysql://localhost:3306/school";
			
			try {
				
				Class.forName(myDriver);
				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "");
				
				PreparedStatement ps = con.prepareStatement("create table payment(payID int primary key, memberID varchar(50), payFor varchar(60), payMethod varchar(30), cardNumber int(70), bank varchar(20), amount double, constraint fk_memberID foreign key (memberID) references student(memberID))"); 
				//give the table name according to the registration table in vidula's code
				
				ps.execute();
				
				con.close();
				
				String message = "Welcome";
				request.setAttribute("message", message);
				
				RequestDispatcher rd1 = request.getRequestDispatcher("/VIEWS/MakePayment.jsp");
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
		else if(makePayment != null)
		{
			String message = "Welcome";
			request.setAttribute("message", message);
			
			RequestDispatcher rd1 = request.getRequestDispatcher("/VIEWS/MakePayment.jsp");
			rd1.forward(request, response);
			
			
		}
		else if(UpmakePayment != null)
		{
			String message = "Welcome";
			request.setAttribute("message", message);
			
			RequestDispatcher rd1 = request.getRequestDispatcher("/VIEWS/UpMakePayment.jsp");
			rd1.forward(request, response);
		}
		else if(removePayment != null)
		{
			RequestDispatcher rd2 = request.getRequestDispatcher("/VIEWS/RemovePayment.jsp");
			rd2.forward(request, response);
		}
		else if(editPayment != null)
		{
			RequestDispatcher rd2 = request.getRequestDispatcher("/VIEWS/EditPayment.jsp");
			rd2.forward(request, response);
		}
		else if(fullAmount != null)
		{
			RequestDispatcher rd3 = request.getRequestDispatcher("/VIEWS/FullAmount.jsp");
			rd3.forward(request, response);
		}
	
	}

}
