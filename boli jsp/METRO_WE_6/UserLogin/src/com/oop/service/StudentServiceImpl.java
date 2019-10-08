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


import com.oop.model.Student;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;



public class StudentServiceImpl implements  IStudentService {
	
	public static final Logger log = Logger.getLogger(StudentServiceImpl.class.getName());
	
	private static Connection connection;
	
	private static Statement statement;
	
	static{
		//create table or drop if exist
		createStudentTable();
	}
	
	private PreparedStatement preparedStatement;
	
	
	
	public static void createStudentTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	
	
	public void addStudent(Student student) {

		String memberID = CommonUtil.generateIDs(getStudentIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_STUDENTS));
			connection.setAutoCommit(false);
			
			//Generate member IDs
			student.setMemberID(memberID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, student.getMemberID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, student.getFirstName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, student.getLastName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, student.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, student.getAddress1());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, student.getAddress2());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, student.getCity());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, student.getParent_guardian());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, student.getHomeTelephone());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, student.getMobile());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, student.getDOB());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE,student.getClasses());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, student.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, student.getPassword());
			// Add student
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
	
	
	
	public Student getStudentByID(String memberID) {

		return actionOnStudent(memberID).get(0);
	}
	
	
	
	
	public ArrayList<Student> getStudent() {
		
		return actionOnStudent(null);
	}
	

	
	
	
	
	public void removeStudent(String memberID) {

		// Before deleting check whether member ID is available
		if (memberID != null && !memberID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STUDENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, memberID);
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
	
	private ArrayList<Student> actionOnStudent(String memberID) {

		ArrayList<Student> studentList = new ArrayList<Student>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (memberID != null && !memberID.isEmpty()) {
				/*
				 * Get Student by ID query will be retrieved from
				 * StudentQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, memberID);
			}
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_STUDENTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Student student = new Student(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO),resultSet.getString(CommonConstants.COLUMN_INDEX_THREE),resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR),resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE),resultSet.getString(CommonConstants.COLUMN_INDEX_SIX),resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN),resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT),resultSet.getString(CommonConstants.COLUMN_INDEX_NINE),resultSet.getString(CommonConstants.COLUMN_INDEX_TEN),resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN),resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE),resultSet.getString(CommonConstants.COLUMN_INDEX_THIRTEEN),resultSet.getString(CommonConstants.COLUMN_INDEX_FOURTEEN));

				
				student.setMemberID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				student.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				student.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				student.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				student.setAddress1(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				student.setAddress2(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				student.setCity(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				student.setParent_guardian(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				student.setHomeTelephone(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				student.setMobile(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				student.setDOB(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				student.setClasses(resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE));
				student.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_THIRTEEN));
				student.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FOURTEEN));
				studentList.add(student);
				
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
		return studentList;
	}
	
	
	
	
	
	
	
	public Student updateStudent(String memberID, Student student) {

		/*
		 * Before fetching student it checks whether member ID is available
		 */
		if (memberID != null && !memberID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STUDENT));

				
				
				
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, student.getFirstName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, student.getLastName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, student.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, student.getAddress1());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, student.getAddress2());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, student.getCity());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, student.getParent_guardian());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, student.getHomeTelephone());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, student.getMobile());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, student.getDOB());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, student.getClasses());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, student.getUserName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, student.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, student.getMemberID());
				
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
		
		
		// Get the updated Student
		return getStudentByID(memberID);
		
	}
		
		private ArrayList<String> getStudentIDs(){
			
			ArrayList<String> arrayList = new ArrayList<String>();
			/*
			 * List of employee IDs will be retrieved from StudentQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT_IDS));
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
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








