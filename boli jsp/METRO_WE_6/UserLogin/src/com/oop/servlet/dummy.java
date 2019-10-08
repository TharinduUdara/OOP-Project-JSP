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

import com.oop.model.Search;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;


/**
 * Servlet implementation class dummy
 */
@WebServlet("/dummy")
public class dummy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dummy() {
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
		String URL = "jdbc:mysql://localhost:3306/school";
		
		
		Search s2=new Search();
		
		try {
			
			s2.setSearch(request.getParameter("search"));
			

			Class.forName(myDriver);
			
			java.sql.Connection con =DriverManager.getConnection(CommonUtil.properties.getProperty(CommonConstants.URL),
	        		CommonUtil.properties.getProperty(CommonConstants.USERNAME), CommonUtil.properties.getProperty(CommonConstants.PASSWORD));
			
			
			PreparedStatement ps = con.prepareStatement("select * from student where firstName like'%"+s2.getSearch()+"%'");
			
			

			ResultSet rs = ps.executeQuery();
			
			request.setAttribute("result", rs);
			
			RequestDispatcher searchDispatcher=getServletContext().getRequestDispatcher("/Search.jsp");
			searchDispatcher.forward(request,response);
					
			
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
