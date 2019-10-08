package com.oop.service;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.model.Exam;
import com.oop.util.DBConnection;


/**
 * Contract for the implementation of AddExamService Service .
 * 
 * @author S.D.S.L Dissanayake(IT18045840), SLIIT
 * @version 1.0
 */

public class AddExamService implements GetDataService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(AddExamService.class.getName());
	private static final ResultSet ResultEX = null;
	
	/**
	 * This method create Exam Table in database if it not exist in database
	 * 
	 */	
	
	public AddExamService() {
		DBConnection.CreateExamTable();
		
	}
	
	
	
	
	/**
	 * This method insert data to Exam tableIf data insert to database it return True value.
	 * if it not return false value 
	 * @parameter addExam			Exam type object 
	 * @return						return boolean value
	 * 
	 */	
	public boolean addExam(Exam addExam) {
		System.out.println(addExam.getexamId());
		String SQLQuery="insert into exam(examID,examName,examSubject,examGrade,examLocation)VALUES("+addExam.getexamId()+",'"+addExam.getexamName()+"','"+addExam.getsubject()+"','"+addExam.getgrade()+"','"+addExam.getlocation()+"')";
		return DBConnection.getConnection().InsertQuery(SQLQuery);
			
		
	
	
	}
		
	/**
	 * This method retrieve all data in Table.this method use to show data in 
	 * index.jsp
	 * 
	 *  @return Result			Return exam data from Exam Table 
	 * 
	 */
	public ResultSet getTable(){
		
		
		
		String SQLQuery1="SELECT *  from exam ";
		ResultSet Result= DBConnection.getConnection().getResult(SQLQuery1);
		
		return Result;
	}
	
	
	/**
	 * This method retrieve Table data using id.This help to load data to update Exam form 
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
	 * 
	 * @parameter Id			Exam id use to get data about particular exam
	 * @return	  ResultEX		Return ResultSet this Result load to Update form 	
	 * 
	 * 
	 * 
	 */
	
	public ResultSet getTableByID(String Id){
		
		String SQLQuery2="SELECT * FROM exam WHERE examID = "+Id;
		System.out.println(SQLQuery2);
		try {
		ResultSet ResultEX= DBConnection.getConnection().getResult(SQLQuery2);
		return ResultEX;
		}catch(Exception SQL ) {
			log.log(Level.SEVERE, SQL.getMessage());
		}
		return ResultEX;
	}
	
	
	/**
	 * This method get Table using by KeyWord
	 * This method help to search  data in Table  
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
	 *  @parameter  keyword			Search keyword           
	 *  @parameter  keyType			Search keyword Type         
	 *  @return     ResultEX        Search Result    
	 *             
	 * 
	 */
	public ResultSet getTableByKeyWord(String keyword,String keyType){
		
		String SQLQuery2="SELECT * FROM exam WHERE "+ keyType +" LIKE '%"+keyword+"%';";
		System.out.println(SQLQuery2);
		try {
		ResultSet ResultEX= DBConnection.getConnection().getResult(SQLQuery2);
		return ResultEX;
		}catch(Exception SQL ) {
			log.log(Level.SEVERE, SQL.getMessage());
		}
		return ResultEX;
	}
	
	
	
	
	/**
	 * This method Edit Exam table Data UpdateExam.jsp sent Edited new data to this method
	 * This method update SQL table 
	 * @parameter  eid			Id of Exam we try to edit
	 * @parameter  ename		name of exam we edite
	 * @parameter  esubject		Subject of Edited exam
	 * @parameter  egrade		Grade of Exam 
	 * @parameter  location		Location of exam
	 * 
	 */
		
	public void updateTable(int eid,String ename,String esubject,String egrade,String location ) {
		
		String id =Integer.toString(eid);
		String updateQuery="UPDATE exam SET examName ='"+ename+"',examSubject ='"+esubject+"',examGrade = '"+egrade+"',examLocation='"+location+"' WHERE examID = "+id; 
		System.out.println(updateQuery);
		DBConnection.getConnection().InsertQuery(updateQuery);
		System.out.println("update table!");
	}
	
	/**
	 * This method use to delete data in table @parameter id use to find particular 
	 * Row in tababse table
	 */
	public void deleteData(int eid ) {
		
		
		String deleteQuery="DELETE FROM exam WHERE examID = "+eid; 
		DBConnection.getConnection().InsertQuery(deleteQuery);
		System.out.println("delete table!");
		
	}
	
	
	
}
