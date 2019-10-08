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
 * Servlet implementation class fullAmount
 */
@WebServlet("/fullAmount")
public class fullAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fullAmount() {
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
		
		String submit = (request.getParameter("submit"));
		String submit1 = (request.getParameter("submit1"));
		String submit2 = (request.getParameter("submit2"));
		
		try {
			
			Payment p1 = new Payment();
			
			p1.setMemberID(request.getParameter("userID"));
			
			Class.forName(myDriver);
			
			java.sql.Connection con =DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
			
			PreparedStatement ps = con.prepareStatement("select * from Payment where memberID = '"+p1.getMemberID()+"'"); //where uname = '\"+user1.getUname()+\"'\
			
			ResultSet rs = ps.executeQuery();
			
			PreparedStatement ps1 = con.prepareStatement("select * from toBePaid where memberID = '"+p1.getMemberID()+"'"); //where uname = '\"+user1.getUname()+\"'\
			
			ResultSet rs1 = ps1.executeQuery();
			
			rs.next();
			rs1.next();
			
			
			if(submit != null && rs.getString(2).equals(p1.getMemberID()) && rs1.getString(1).equals(p1.getMemberID()))
			{
						String payID = rs.getString("payID");
						request.setAttribute("payID", payID);
						
						String memID = rs.getString("memberID");
						request.setAttribute("memID", memID);
						
						String payFor = rs.getString("payFor");
						request.setAttribute("payFor", payFor);
						
						String payMe = rs.getString("payMethod");
						request.setAttribute("payMe", payMe);
						
						String cardNum = rs.getString("cardNumber");
						request.setAttribute("cardNum", cardNum);
						
						String bank = rs.getString("bank");
						request.setAttribute("bank", bank);
						
						String amount = rs.getString("amount");
						request.setAttribute("amount", amount);
						
						//
						String memID1 = rs1.getString("memberID");
						request.setAttribute("memID1", memID1);
						
						double fee = rs1.getDouble("Fee");
						request.setAttribute("fee", fee);
						
						double extra = rs1.getDouble("ExtraCurricular");
						request.setAttribute("extra", extra);
						
						double add = rs1.getDouble("Additional");
						request.setAttribute("add", add);
						
						/*String message = "Successful!!!!";
						request.setAttribute("message", message);*/
						
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/VIEWS/display.jsp");
						rd.forward(request, response);
			}
			
			else if(submit1 != null && rs.getString(2).equals(p1.getMemberID()))
			{
				String payID = rs.getString("payID");
				request.setAttribute("payID", payID);
				
				String memID = rs.getString("memberID");
				request.setAttribute("memID", memID);
				
				String payFor = rs.getString("payFor");
				request.setAttribute("payFor", payFor);
				
				String payMe = rs.getString("payMethod");
				request.setAttribute("payMe", payMe);
				
				String cardNum = rs.getString("cardNumber");
				request.setAttribute("cardNum", cardNum);
				
				String bank = rs.getString("bank");
				request.setAttribute("bank", bank);
				
				String amount = rs.getString("amount");
				request.setAttribute("amount", amount);
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/VIEWS/display1.jsp");
				rd.forward(request, response);
			}
			
			else if(submit2 != null && rs1.getString(1).equals(p1.getMemberID()))
			{
				String memID1 = rs1.getString("memberID");
				request.setAttribute("memID1", memID1);
				
				double fee = rs1.getDouble("Fee");
				request.setAttribute("fee", fee);
				
				double extra = rs1.getDouble("ExtraCurricular");
				request.setAttribute("extra", extra);
				
				double add = rs1.getDouble("Additional");
				request.setAttribute("add", add);
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/VIEWS/display2.jsp");
				rd.forward(request, response);
				
			}
			
			con.close();
		
				
		}
				catch(Exception e)
				{
					String message = "Unsuccessful, enter Again";
					request.setAttribute("message", message);
					
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/VIEWS/FullAmount.jsp");
					rd.forward(request, response);
					
					System.out.println("Exception is occured");
					System.out.println(e.getMessage());
				}
		
					finally
					{
						
					}
	}

}
