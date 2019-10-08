package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*this Class use to Connect with MySQL Database*/
/**
 * This class use to connect with MySQL database
 * @author S.D.S.L Dissanayake (IT18045840), SLIIT
 * @version 1.0
 */



public class DBConnection {
		
	// This works according to singleton pattern

	static Connection connect;
	private static DBConnection uniqueInstant=null;
	private DBConnection() {
		
	}
	
	
	public static DBConnection getConnection() {
		if(uniqueInstant==null) {
			uniqueInstant=new DBConnection();
		}
		
		return uniqueInstant;
				
	}
		
	/**
	 * Create Database connection for the given URL, Username and Password
	 * 
	 * @return Connection this returns SQL connection for MySql Database
	 * 
	 * @throws SQLException
	 *             - An exception that provides information on a database access
	 *             error or other errors
	 */
		
	
	
	
	public static Connection ConnectDB() throws SQLException{
		String username=CommonUtil.properties.getProperty(CommonConstants.USERNAME);
		String password =CommonUtil.properties.getProperty(CommonConstants.PASSWORD);
		String url=CommonUtil.properties.getProperty(CommonConstants.URL);
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				connect=DriverManager.getConnection(url,username,password);
				
				} catch (ClassNotFoundException e) {
				
					System.out.println(e);
			
				}catch(SQLException e) {
					
				}
			return connect;
		
	}
	
	/**
	 * 
	 * Execute SQL Query and return boolean value 
	 * 
	 *  
	 * @throws SQLException
	 *             - An exception that provides information on a database access
	 *             error or other errors
	 * @parameter  Query			SQL Query this is a String value
	 *     	           
	 *             
	 */
		
	
	public boolean InsertQuery(String Query) {
				try {
			
			
			Statement  sqlStatment = ConnectDB().createStatement();
			boolean sqlstatus= sqlStatment.execute(Query);
			return true;
			      
		} catch (SQLException e) {
			return false;
			
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 

	}
	
	/**
	 * 
	 * Execute SQL Query and return boolean value 
	 * 
	 * @return Return a Result set 
	 * 
	  @parameter  Query			SQL Query this is a String value
	 *     	           
	 *             
	 */
	
	
	
	
	
	public ResultSet getResult(String Query)  {
		
		
		try {
			
			Statement satatnetx=ConnectDB().createStatement();
			ResultSet resultSet=satatnetx.executeQuery(Query);
			return resultSet;
		}catch(SQLException ex) {
			
			System.out.println(ex);
			
		}
		
			return null;
		
	}
	
	/**
	 * 
	 * This method create Reminder table if it not exit in database  
	 *  
	 *             
	 */
	
	
	public static void CreateReminderTable(){
				
		try {
			PreparedStatement createTable1=ConnectDB().prepareStatement("CREATE TABLE IF NOT EXISTS reminder (reminderID VARCHAR(20) PRIMARY KEY,reminder VARCHAR(140),date_time VARCHAR(50));");
			createTable1.executeUpdate();
			
		}catch(Exception e ){
			System.out.println("create table excestion is :");
		}
		
		
		
	}
	
	/**
	 * 
	 * This method create Exam table if it not exit in database  
	 *  
	 *             
	 */
	
	public static void CreateExamTable() {
		
		try {
			PreparedStatement createTable2=ConnectDB().prepareStatement("CREATE TABLE IF NOT EXISTS exam (examID INT(11) PRIMARY KEY,examName VARCHAR(20),examSubject VARCHAR(20),examGrade VARCHAR(20),examLocation VARCHAR(20));");
			createTable2.executeUpdate();
			
		}catch(Exception e){
			System.out.println("create table excestion is :"+ e);
		}
		
		
		
	}
	
	
	
	
	
	
	
	




}
