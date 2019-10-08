package com.oop.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.ReminderService;

/**
 * Servlet implementation class ReminderServlet
 */
@WebServlet("/ReminderServlet")
public class ReminderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReminderServlet() {
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
		
		 
		 
		 String ReminderButton=request.getParameter("reminderBtn");
			
			if(ReminderButton.equals("addnew")) {
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/webpage/AddReminder.jsp");
					dispatcher.forward(request, response);
					
			}else if(ReminderButton.equals("searchReminder")) {
					
					String searchText=request.getParameter("reminder_text");
					String searchType=request.getParameter("reminder_type");
					
					ReminderService reminderSearch=new ReminderService();
					ResultSet getSerchData=reminderSearch.getTableByKeyWord(searchText,searchType);
					request.setAttribute("SerchResultRimnder", getSerchData);
				 
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Teacherdashbord.jsp");
					dispatcher.forward(request, response);
					
					
					
		}
		 
		 
	}

}
