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

public class AddTeacherServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public AddTeacherServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		Teacher teacher=new Teacher(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("gender"), request.getParameter("address1"), request.getParameter("address2"), request.getParameter("city"), request.getParameter("homeTelephone"), request.getParameter("mobile"), request.getParameter("DOB"),request.getParameter("userName"), request.getParameter("password"),request.getParameter("NIC"),request.getParameter("rClass"));
		
 
		teacher.setFirstName(request.getParameter("firstName"));
		teacher.setLastName(request.getParameter("lastName"));
		teacher.setGender(request.getParameter("gender"));
		teacher.setAddress1(request.getParameter("address1"));
		teacher.setAddress2(request.getParameter("address2"));
		teacher.setCity(request.getParameter("city"));
		teacher.setHomeTelephone(request.getParameter("homeTelephone"));
		teacher.setMobile(request.getParameter("mobile"));
		teacher.setDOB(request.getParameter("DOB"));
		teacher.setUserName(request.getParameter("userName"));
		teacher.setPassword(request.getParameter("password"));
		teacher.setNIC(request.getParameter("NIC"));
		teacher.setrClass(request.getParameter("rClass"));
		
		
		
		
		ITeacherService iStudentService = new TeacherServiceImpl();
		iStudentService.addTeacher(teacher);
		
		request.setAttribute("teacher", teacher);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListTeacher.jsp");
		dispatcher.forward(request, response);
	}


}
