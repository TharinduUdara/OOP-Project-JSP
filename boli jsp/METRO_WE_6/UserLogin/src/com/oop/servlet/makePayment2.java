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
 * Servlet implementation class makePayment2
 */
@WebServlet("/makePayment2")
public class makePayment2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makePayment2() {
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
			
			p1.setPayID(Integer.parseInt(request.getParameter("payID")));
			
			p1.setMemberID(request.getParameter("memID"));
			
			p1.setPayFor(request.getParameter("payFor"));
			
			p1.setPayMethod(request.getParameter("payMethod"));
			
			p1.setCardNumber(Integer.parseInt(request.getParameter("cardNumber")));
			
			p1.setBank(request.getParameter("bank"));
			
			p1.setAmount(Integer.parseInt(request.getParameter("amount")));
			
			Class.forName(myDriver);
			
			java.sql.Connection con =DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
			
			PreparedStatement ps = con.prepareStatement("insert into Payment values('"+p1.getPayID()+"', '"+p1.getMemberID()+"' , '"+p1.getPayFor()+"', '"+p1.getPayMethod()+"','"+p1.getCardNumber()+"', '"+p1.getBank()+"', '"+p1.getAmount()+"')");
			
			ps.execute();
			
			//PreparedStatement ps1 = con.prepareStatement("select max(payID) from payment");
			
			//ResultSet rs = ps1.executeQuery();
			
			//int pay_count = Integer.parseInt(rs.getString("payID") + 1);
		    
		    //request.setAttribute("pay_count", pay_count);
		    
		    RequestDispatcher rd1 = request.getRequestDispatcher("/VIEWS/PayDisplay.jsp");
			rd1.forward(request, response);
		    
			con.close();
			
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
