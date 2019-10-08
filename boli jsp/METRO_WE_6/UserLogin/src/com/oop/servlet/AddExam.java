package com.oop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Exam;
import com.oop.service.AddExamService;

/**
 * This class use to connect with MySQL database
 * @author S.D.S.L Dissanayake (IT18045840), SLIIT
 * @version 1.0
 */

/**
 * Servlet implementation class AddExam
 */
@WebServlet("/AddExam")
public class AddExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExam() {
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
		response.setContentType("text/html");
		
				String examButton=request.getParameter("examButton");
				
						if(examButton.equals("save")) {
							Exam exam=new Exam();
							
							String ExamName=request.getParameter("examName");
							String ExamSubject=request.getParameter("examSubject");
							String ExamGrade=request.getParameter("examGrade");
							String ExamLocation=request.getParameter("examLocation");
							
							exam.setExam(ExamName, ExamSubject, ExamGrade, ExamLocation);
							AddExamService addExam=new AddExamService();
							addExam.addExam(exam);
							response.sendRedirect("/UserLogin/Teacherdashbord.jsp");
												
							
						
						}else if(examButton.equals("cancel")) {
							response.sendRedirect("/UserLogin/Teacherdashbord.jsp");
														
						}
				
				
		
		
		
		
		
		
		
		
		
		
	}

}
