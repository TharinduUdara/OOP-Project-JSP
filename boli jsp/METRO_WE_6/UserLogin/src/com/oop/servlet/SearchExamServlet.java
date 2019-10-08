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

/**
 * Servlet implementation class SearchExamServlet
 */
@WebServlet("/SearchExamServlet")
public class SearchExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchExamServlet() {
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
		
		
		String searchTextx=request.getParameter("Exam_Search_text");
		String searchTypex=request.getParameter("Exam_select");
								 				 
		
		
		 AddExamService examSearch=new AddExamService();
		 ResultSet getSerchData=examSearch.getTableByKeyWord(searchTextx,searchTypex);
		 request.setAttribute("SerchResult", getSerchData);
		 
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacherdashbord.jsp");
		 dispatcher.forward(request, response);
		
		
		

	}
	
}
