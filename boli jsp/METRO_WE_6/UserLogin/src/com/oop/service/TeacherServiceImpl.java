//@author vidula IT18026962
package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import com.oop.model.Teacher;
import com.oop.util.CommonConstants1;
import com.oop.util.CommonUtil1;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil1;



public class TeacherServiceImpl implements  ITeacherService {
	
	public static final Logger log = Logger.getLogger(TeacherServiceImpl.class.getName());
	
	private static Connection connection;
	
	private static Statement statement;
	
	static{
		//create table or drop if exist
		createTeacherTable();
	}
	
	private PreparedStatement preparedStatement;
	
	
	
	public static void createTeacherTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_DROP_TABLE1));
			// Create new employees table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	
	
	public void addTeacher(Teacher teacher) {

		String teacherID = CommonUtil1.generateIDs(getTeacherIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_INSERT_TEACHERS));
			connection.setAutoCommit(false);
			
			//Generate employee IDs
			teacher.setMemberID(teacherID);
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_ONE, teacher.getMemberID());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_TWO, teacher.getFirstName());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_THREE, teacher.getLastName());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_FOUR, teacher.getGender());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_FIVE, teacher.getAddress1());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_SIX, teacher.getAddress2());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_SEVEN, teacher.getCity());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_EIGHT, teacher.getHomeTelephone());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_NINE, teacher.getMobile());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_TEN, teacher.getDOB());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_ELEVEN, teacher.getUserName());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_TWELVE, teacher.getPassword());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_THIRTEEN,teacher.getNIC());
			preparedStatement.setString(CommonConstants1.COLUMN_INDEX_FOURTEEN, teacher.getrClass());
			
			
			
			// Add employee
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	
	public Teacher getTeacherByID(String teacherID) {

		return actionOnTeacher(teacherID).get(0);
	}
	
	
	
	public ArrayList<Teacher> getTeacher() {
		
		return actionOnTeacher(null);
	}
	
	
	
	
	public void removeTeacher(String teacherID) {

		// Before deleting check whether employee ID is available
		if (teacherID != null && !teacherID.isEmpty()) {
			/*
			 * Remove employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_REMOVE_TEACHER));
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_ONE, teacherID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}
	
	
	/****************************/
	
	private ArrayList<Teacher> actionOnTeacher(String teacherID) {

		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (teacherID != null && !teacherID.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_GET_TEACHER));
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_ONE, teacherID);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_ALL_TEACHERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher(resultSet.getString(CommonConstants1.COLUMN_INDEX_TWO),resultSet.getString(CommonConstants1.COLUMN_INDEX_THREE),resultSet.getString(CommonConstants1.COLUMN_INDEX_FOUR),resultSet.getString(CommonConstants1.COLUMN_INDEX_FIVE),resultSet.getString(CommonConstants1.COLUMN_INDEX_SIX),resultSet.getString(CommonConstants1.COLUMN_INDEX_SEVEN),resultSet.getString(CommonConstants1.COLUMN_INDEX_EIGHT),resultSet.getString(CommonConstants1.COLUMN_INDEX_NINE),resultSet.getString(CommonConstants1.COLUMN_INDEX_TEN),resultSet.getString(CommonConstants1.COLUMN_INDEX_ELEVEN),resultSet.getString(CommonConstants1.COLUMN_INDEX_TWELVE),resultSet.getString(CommonConstants1.COLUMN_INDEX_THIRTEEN),resultSet.getString(CommonConstants1.COLUMN_INDEX_FOURTEEN));

				
				teacher.setMemberID(resultSet.getString(CommonConstants1.COLUMN_INDEX_ONE));
				teacher.setFirstName(resultSet.getString(CommonConstants1.COLUMN_INDEX_TWO));
				teacher.setLastName(resultSet.getString(CommonConstants1.COLUMN_INDEX_THREE));
				teacher.setGender(resultSet.getString(CommonConstants1.COLUMN_INDEX_FOUR));
				teacher.setAddress1(resultSet.getString(CommonConstants1.COLUMN_INDEX_FIVE));
				teacher.setAddress2(resultSet.getString(CommonConstants1.COLUMN_INDEX_SIX));
				teacher.setCity(resultSet.getString(CommonConstants1.COLUMN_INDEX_SEVEN));
				teacher.setHomeTelephone(resultSet.getString(CommonConstants1.COLUMN_INDEX_EIGHT));
				teacher.setMobile(resultSet.getString(CommonConstants1.COLUMN_INDEX_NINE));
				teacher.setDOB(resultSet.getString(CommonConstants1.COLUMN_INDEX_TEN));
				teacher.setUserName(resultSet.getString(CommonConstants1.COLUMN_INDEX_ELEVEN));
				teacher.setPassword(resultSet.getString(CommonConstants1.COLUMN_INDEX_TWELVE));
				teacher.setNIC(resultSet.getString(CommonConstants1.COLUMN_INDEX_THIRTEEN));
				teacher.setrClass(resultSet.getString(CommonConstants1.COLUMN_INDEX_FOURTEEN));
				teacherList.add(teacher);
				
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return teacherList;
	}
	
	
	
	public Teacher updateTeacher(String teacherID, Teacher teacher) {

		/*
		 * Before fetching employee it checks whether employee ID is available
		 */
		if (teacherID != null && !teacherID.isEmpty()) {
			/*
			 * Update employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_UPDATE_TEACHER));

				
				
				
				
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_ONE, teacher.getFirstName());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_TWO, teacher.getLastName());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_THREE, teacher.getGender());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_FOUR, teacher.getAddress1());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_FIVE, teacher.getAddress2());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_SIX, teacher.getCity());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_SEVEN, teacher.getHomeTelephone());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_EIGHT, teacher.getMobile());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_NINE, teacher.getDOB());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_TEN, teacher.getUserName());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_ELEVEN, teacher.getPassword());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_TWELVE,teacher.getNIC());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_THIRTEEN,teacher.getrClass());
				preparedStatement.setString(CommonConstants1.COLUMN_INDEX_FOURTEEN, teacher.getMemberID());
				
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		
		// Get the updated employee
		return getTeacherByID(teacherID);
		
	}
		
		private ArrayList<String> getTeacherIDs(){
			
			ArrayList<String> arrayList = new ArrayList<String>();
			/*
			 * List of employee IDs will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil1.queryByID(CommonConstants1.QUERY_ID_GET_TEACHER_IDS));
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					arrayList.add(resultSet.getString(CommonConstants1.COLUMN_INDEX_ONE));
				}
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of
				 * transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return arrayList;
		}










	}

