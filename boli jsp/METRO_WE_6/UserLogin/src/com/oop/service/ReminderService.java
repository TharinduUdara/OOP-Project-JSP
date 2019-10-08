package com.oop.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.model.Reminder;
import com.oop.util.DBConnection;

public class ReminderService implements GetDataService {

	public static final Logger log = Logger.getLogger(ReminderService.class.getName());
	private static final ResultSet ResultEX = null;

	/**
	 * If Reminder table is not exist in DataBase this method
	 * create table in Database
	 * 
	 */
	
	public  ReminderService() {
		DBConnection.CreateReminderTable();
	}
	
	/**
	 * This method get data form table.This help to show table data in index.jsp
	 * @return  Result		return table data about Reminders 
	 * 
	 * 
	 */

	@Override
	public ResultSet getTable() {
				
		
		String SQLQuery="SELECT *  from reminder";
		ResultSet Result= DBConnection.getConnection().getResult(SQLQuery);
		return Result;
	}

	/**
	 * This method get table data by using key word
	 * this is help to search @parameter keyword and
	 * @parameter keyType use to search data 
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @paremeter keyword 		Search key word
	 * @paremeter keyType 		Search word Type
	 * @return    ResultEX		Return Search result according	to keyword and keyType
	 * 
	 */
	
	@Override
	public ResultSet getTableByKeyWord(String keyword, String keyType) {
		
		String SQLQuery2="SELECT *  from reminder WHERE "+ keyType +" LIKE '%"+keyword+"%';";
		System.out.println(SQLQuery2);
		try {
		ResultSet ResultEX= DBConnection.getConnection().getResult(SQLQuery2);
		System.out.println("send succsfuly");
		return ResultEX;
		
		}catch(Exception SQL ) {
			log.log(Level.SEVERE, SQL.getMessage());
		}
		return ResultEX;
	}
	
	/**
	 * This method add  data to table
	 * @parameter  reminder			Reminder Type object
	 * @return     					boolean value
	 */
	
	
	public boolean addReminder(Reminder reminder) {
		
		System.out.println(reminder.getRemiderID());
		String SQLQuery="insert into reminder(reminderID,reminder,date_time)VALUES('"+reminder.getRemiderID()+"','"+reminder.getReminder()+"','"+reminder.getDatenadTime()+"')";
		System.out.println("reminder add");
		return DBConnection.getConnection().InsertQuery(SQLQuery);
			
		
	}
	
	/**
	 * This method update Reminder table data 
	 * @paramenter reminderID			Id of particular reminder 
	 * @paramenter reminder				content of reminder 
	 * @paramenter reminderDate			reminder date	
	 * 
	 * 
	 */
		
	public void updateTable(int reminderID,String reminder,String remindDate ) {
		
		String id =Integer.toString(reminderID);
		String updateQuery="UPDATE reminder SET reminderID ='"+reminderID+"',reminder ='"+reminder+"',date_time = '"+remindDate+"' WHERE reminderID = "+reminderID; 
		System.out.println(updateQuery);
		DBConnection.getConnection().InsertQuery(updateQuery);
		System.out.println("update table!");
	}
	
	/**
	 * This method delete data in Reminder Table using table id
	 * @parameter reminderID			use reminder id use to identify reminder in table   
	 * 
	 */
	public void deleteData(int reminderID ) {
		
		
		String deleteQuery="DELETE FROM reminder WHERE reminderID = "+reminderID; 
		DBConnection.getConnection().InsertQuery(deleteQuery);
		System.out.println("delete table!!");
		
	}
	
	

}
