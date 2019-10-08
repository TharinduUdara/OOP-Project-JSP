package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Exam;
import com.oop.service.AddExamService;


/**
 * Servlet implementation class UpdateExam
 */
@WebServlet("/UpdateExamServerlet")
public class UpdateExamServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExamServerlet() {
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
		
		
		String updateExamButn=request.getParameter("examButton");
		
		
		int ExamId= Integer.parseInt(request.getParameter("examID"));
		String ExamName=request.getParameter("examName");
		String examSubject=request.getParameter("examSubject");
		String examGrade =request.getParameter("examGrade");
		String examLocation=request.getParameter("examLocation");
		System.out.println(" exam ID "+ExamId);
		
		AddExamService updateExam=new AddExamService();
		
		
		if(updateExamButn.equals("update")) {
			updateExam.updateTable(ExamId, ExamName, examSubject, examGrade,examLocation);
			RequestDispatcher updateDispatcher =getServletContext().getRequestDispatcher("/Teacherdashbord.jsp");
			updateDispatcher.forward(request, response);
			
		}else if(updateExamButn.equals("delete")) {
			updateExam.deleteData(ExamId);
			response.sendRedirect("/UserLogin/Teacherdashbord.jsp");
			
		}else if(updateExamButn.equals("cancel")){
		
			response.sendRedirect("/UserLogin/Teacherdashbord.jsp");
		}
		
		
	}

}
