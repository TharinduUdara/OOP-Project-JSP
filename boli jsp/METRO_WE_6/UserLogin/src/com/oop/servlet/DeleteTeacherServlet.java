//@author vidula IT18026962
package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.ITeacherService;
import com.oop.service.TeacherServiceImpl;

public class DeleteTeacherServlet extends HttpServlet{
	
private static final long serialVersionUID = 1871871796669342804L;
	
	public DeleteTeacherServlet() {
		super();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String teacherID = request.getParameter("teacherID");			
		
		ITeacherService iteacherService = new TeacherServiceImpl();
		iteacherService.removeTeacher(teacherID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListTeacher.jsp");
		dispatcher.forward(request, response);
	}
	

}
