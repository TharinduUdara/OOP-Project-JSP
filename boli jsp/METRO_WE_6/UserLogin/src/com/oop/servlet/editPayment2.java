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
 * Servlet implementation class editPayment2
 */
@WebServlet("/editPayment2")
public class editPayment2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPayment2() {
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
			
			//p1.setPayID(request.getParameter("payID"));
			
			p1.setMemberID(request.getParameter("memID"));
			
			p1.setPayFor(request.getParameter("payFor"));
			
			p1.setPayMethod(request.getParameter("payMethod"));
			
			p1.setCardNumber(Integer.parseInt(request.getParameter("cardNumber")));
			
			p1.setBank(request.getParameter("bank"));
			
			p1.setAmount(Integer.parseInt(request.getParameter("amount")));
			
			
			Class.forName(myDriver);
			
			java.sql.Connection con =DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
			
			PreparedStatement ps = con.prepareStatement("update Payment set payID = '"+p1.getPayID()+"', memberID = '"+p1.getMemberID()+"', payFor = '"+p1.getPayFor()+"', payMethod = '"+p1.getPayMethod()+"', cardNumber = '"+p1.getCardNumber()+"', bank = '"+p1.getBank()+"', amount = '"+p1.getAmount()+"' where memberID = '"+p1.getMemberID()+"'");
			
			ps.execute();
		      
		    con.close();
		    
		    RequestDispatcher rd1 = request.getRequestDispatcher("/VIEWS/ConfirmEdit.jsp");
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
