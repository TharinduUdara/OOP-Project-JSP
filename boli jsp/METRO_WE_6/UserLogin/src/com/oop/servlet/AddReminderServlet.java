package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Reminder;
import com.oop.service.ReminderService;

/**
 * Servlet implementation class AddReminderServlet
 */
@WebServlet("/AddReminderServlet")
public class AddReminderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReminderServlet() {
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
		
		String ReminderButton=request.getParameter("ReminderButton");
		
		if(ReminderButton.equals("save")) {
		
			
			String Reminder=request.getParameter("Reminder");
			String RemiderDate=request.getParameter("reminderDate");
			
			
			//exam.setExam(ExamName, ExamSubject, ExamGrade, ExamLocation);
			
			Reminder reminder=new Reminder(Reminder, RemiderDate);
			
			ReminderService addReminder=new ReminderService();
			addReminder.addReminder(reminder);
			response.sendRedirect("/UserLogin/Teacherdashbord.jsp");
								
			
		
		}else if(ReminderButton.equals("cancel")) {
			response.sendRedirect("/UserLogin/Teacherdashbord.jsp");
										
		}
		
		
		
		
		
		
	}

}
