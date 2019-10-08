package com.oop.service;

import java.sql.ResultSet;
import java.util.logging.Logger;

import com.oop.util.DBConnection;
/**
 * Contract for the implementation of Teacher Service .
 * 
 * @author S.D.S.L Dissanayake(IT18045840), SLIIT
 * @version 1.0
 */

public class TeacherService  {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(TeacherService.class.getName());
	private static final ResultSet ResultEX = null;
	private static String Teacher_Id;
	
	/**
	 * Return the Resultset that help to show Teacher profile data in
	 * Teacher dashbord. 
	 * 
	 */
	
	public ResultSet getTable(String username){
	
		String turnm=username;
		String SQLQuery="SELECT * from teacher WHERE teacherID ='"+username +"'";
		
		ResultSet Result= DBConnection.getConnection().getResult(SQLQuery);
		return Result;
	}

	
	
	

	/**
	 * @return the teacher_Id
	 */
	

	/**
	 * @param teacher_Id the teacher_Id to set
	 * To show teacher profile Teacher Id should set to this method
	 *
	 */

	
	
	
	
	
	
}
