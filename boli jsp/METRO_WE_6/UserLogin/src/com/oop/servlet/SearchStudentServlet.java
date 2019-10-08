package com.oop.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.AddExamService;
import com.oop.service.StudentService;

/**
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentServlet() {
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
		String searchText=request.getParameter("Student_input");
		String searchType=request.getParameter("Student_type");
		
		
		 
		 if(searchText.equals("")) {
			 
		 }else {
			 StudentService studentSearch=new StudentService();
			 ResultSet getSerchData=studentSearch.getTableByKeyWord(searchText,searchType);
			 request.setAttribute("SerchResultStudent", getSerchData);
			 
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacherdashbord.jsp");
			 dispatcher.forward(request, response);
			 
		 }
		 
		 
	}

}
