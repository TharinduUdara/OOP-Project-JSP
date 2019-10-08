package com.oop.model;

public class Exam {
	private String examName;
	private static int examID=0; //exam id initialize  to zero
	private String subject;
	private String grade;
	private String location;
	
	/**
	 * @parameter Examid the Examid to set
	 * @parameter exName the exName to set
	 * @parameter exsubject the exsubject to set
	 * @parameter exgrade the exgrade to set
	 * @parameter exlocation the exlocation to set
	 */
	
	public void setExam(String exName,String exsubject,String exgrade,String exlocation) {
		this.examName=exName;
		this.subject=exsubject;
		this.grade=exgrade;
		this.location=exlocation;
		examID=examID+1;
	}
	
	/**
	 * @parameter Examid the Examid to set
	 * @parameter exName the exName to set
	 * @parameter exsubject the exsubject to set
	 * @parameter exgrade the exgrade to set
	 * @parameter exlocation the exlocation to set
	 */
	public void setExam(int Examid, String exName,String exsubject,String exgrade,String exlocation) {
		this.examName=exName;
		this.subject=exsubject;
		this.grade=exgrade;
		this.location=exlocation;
		this.examID=Examid;
		
	}
	
	/**
	 * @return the examName
	 */
	public String getexamName() {
		return examName;
	}
	
	/**
	 * @return the subject
	 */
	
	public String getsubject() {
		return subject;
	}
	
	/**
	 * @return the grade
	 */
	public String getgrade() {
		return grade;
	}
	
	/**
	 * @return the location
	 */
	public String getlocation() {
		return location;
	}
	
	/**
	 * @return the examID
	 */
	public static int  getexamId() {
		return examID;
	}
	
	
	
	
}
