//@author vidula IT18026962
package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.IStudentService;
import com.oop.service.StudentServiceImpl;



public class DeleteStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1871871796669342804L;
	
	public DeleteStudentServlet() {
		super();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String memberID = request.getParameter("memberID");			
		
		IStudentService iStudentService = new StudentServiceImpl();
		iStudentService.removeStudent(memberID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	
	

}
