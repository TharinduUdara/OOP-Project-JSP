//@author vidula IT18026962
package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oop.model.Student;
import com.oop.service.IStudentService;
import com.oop.service.StudentServiceImpl;

public class GetStudentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public GetStudentServlet() {
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
		Student student = iStudentService.getStudentByID(memberID);

		request.setAttribute("student", student);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetStudent.jsp");
		dispatcher.forward(request, response);
	}

}
