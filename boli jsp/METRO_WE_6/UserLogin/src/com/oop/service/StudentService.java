package com.oop.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.util.DBConnection;
/**
 * Contract for the implementation of Student Service .
 * 
 * @author S.D.S.L Dissanayake(IT18045840), SLIIT
 * @version 1.0
 */
public class StudentService implements GetDataService{
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(StudentService.class.getName());
 	private static final ResultSet ResultEX = null;
	
 	/**
	 * This method retrieve all data in Table.Adn return Resultset object
	 * @return  Result Student table data 
	 * 
	 */
	public ResultSet getTable(){
		String SQLQuery="SELECT memberID,firstName,gender,city,HomeTelephone from student";
		ResultSet Result= DBConnection.getConnection().getResult(SQLQuery);
		
		return Result;
	}
	
	
	/**
	 * This method retrieve Table data using keyword 
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
	 * @parameter keyType 		table column name 
	 * @parameter keyword		Search word
	 * @return	  ResultEX		Return data set according to Search word 
	 * 
	 */
	
	public ResultSet getTableByKeyWord(String keyword,String keyType){
		
		String SQLQuery2="SELECT memberID,firstName,gender,city,HomeTelephone from student WHERE "+ keyType +" LIKE '%"+keyword+"%';";
		System.out.println(SQLQuery2);
		try {
		ResultSet ResultEX= DBConnection.getConnection().getResult(SQLQuery2);
		return ResultEX;
		}catch(Exception SQL ) {
			log.log(Level.SEVERE, SQL.getMessage());
		}
		return ResultEX;
	}
	
	
	
}
