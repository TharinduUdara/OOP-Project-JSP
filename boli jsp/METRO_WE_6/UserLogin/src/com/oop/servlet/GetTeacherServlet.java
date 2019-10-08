//@author vidula IT18026962
package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Teacher;
import com.oop.service.ITeacherService;
import com.oop.service.TeacherServiceImpl;

public class GetTeacherServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public GetTeacherServlet() {
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
		Teacher teacher = iteacherService.getTeacherByID(teacherID);

		request.setAttribute("teacher", teacher);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetTeacher.jsp");
		dispatcher.forward(request, response);
	}


}
