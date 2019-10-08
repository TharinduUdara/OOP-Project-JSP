package com.oop.model;

public class Reminder {
	private static int remiderID=0;
	private String reminder;
	private String DatenadTime;
	
	
	/**
	 * @return the reminder
	 */
	public String getReminder() {
		return reminder;
	}
	/**
	 * @param reminder the reminder to set
	 */
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	/**
	 * @return the remiderID
	 */
	public int getRemiderID() {
		return remiderID;
	}
	/**
	 * @param remiderID the remiderID to set
	 */
	public void setRemiderID(int remiderID) {
		this.remiderID = remiderID;
	}
	/**
	 * @return the datenadTime
	 */
	public String getDatenadTime() {
		return DatenadTime;
	}
	/**
	 * @param datenadTime the datenadTime to set
	 */
	public void setDatenadTime(String datenadTime) {
		DatenadTime = datenadTime;
	}
	
	
	public Reminder(String reminder,String reminderDate) {
		this.reminder=reminder;
		this.DatenadTime=reminderDate;
		remiderID=remiderID+1;
	}
	
	
	
	
	
}
