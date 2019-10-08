package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.ReminderService;

/**
 * Servlet implementation class DeleteReminder
 */
@WebServlet("/DeleteReminder")
public class DeleteReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReminder() {
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
		String deleteReminder=request.getParameter("deleteReminderBtn");
		int remiderID= Integer.parseInt(request.getParameter("remiderID"));
		
		if(deleteReminder.equals("Delete")) {
			
			ReminderService DeleteReminder=new ReminderService();
			DeleteReminder.deleteData(remiderID);
			response.sendRedirect("Teacherdashbord.jsp");
		}
		
		
		
		
	}

}
