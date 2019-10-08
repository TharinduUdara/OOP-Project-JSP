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



public class AddStudentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public AddStudentServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		Student student=new Student(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("gender"), request.getParameter("address1"), request.getParameter("address2"), request.getParameter("city"),request.getParameter("parent_guardian"), request.getParameter("homeTelephone"), request.getParameter("mobile"), request.getParameter("DOB"),request.getParameter("classes"), request.getParameter("userName"), request.getParameter("password"));
		
 
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setGender(request.getParameter("gender"));
		student.setAddress1(request.getParameter("address1"));
		student.setAddress2(request.getParameter("address2"));
		student.setCity(request.getParameter("city"));
		student.setParent_guardian(request.getParameter("parent_guardian"));
		student.setHomeTelephone(request.getParameter("homeTelephone"));
		student.setMobile(request.getParameter("mobile"));
		student.setDOB(request.getParameter("DOB"));
		student.setClasses(request.getParameter("classes"));
		student.setUserName(request.getParameter("userName"));
		student.setPassword(request.getParameter("password"));
		
		
		
		
		IStudentService iStudentService = new StudentServiceImpl();
		iStudentService.addStudent(student);
		
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStudent.jsp");
		dispatcher.forward(request, response);
	}


}
