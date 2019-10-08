package com.oop.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.AddExamService;

/**
 * Servlet implementation class EditExamServlet
 */
@WebServlet("/EditExamServlet")
public class EditExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditExamServlet() {
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
		 
		
		
		 AddExamService getExamByID=new AddExamService();
		 
		 String getExamId= request.getParameter("examID");
		 ResultSet getSelectExam=getExamByID.getTableByID(getExamId);
		 
		
		try {
			while(getSelectExam.next()) {
			 try {
				 String examID= Integer.toString(getSelectExam.getInt(1));
				 String examName= getSelectExam.getString(2);
				 String examSubject= getSelectExam.getString(3);
				 String examGrade= getSelectExam.getString(4);
				 String examLocation= getSelectExam.getString(5);
				 
				 System.out.println(examName);
				request.setAttribute("examId", examID);
				request.setAttribute("examName", examName);
				request.setAttribute("examSubject", examSubject);
				request.setAttribute("examGrade", examGrade);
				request.setAttribute("examLocation", examLocation);
				
				
				
			} catch (Exception e) {
				 System.out.println(e);
				e.printStackTrace();
			}
			 
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 RequestDispatcher updateDispatcher =getServletContext().getRequestDispatcher("/WEB-INF/webpage/UpdateExam.jsp");
		 updateDispatcher.forward(request, response);
		
		
		
	}

}
