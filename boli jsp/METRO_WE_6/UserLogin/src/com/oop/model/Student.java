//@author vidula IT18026962
package com.oop.model;

public class Student extends Member {
	private String parent_guardian;
	private String classes;
	
	

	public Student(String firstName, String lastName,String gender, String address1, String address2, String city,
			String parent_guardian, String homeTelephone, String mobile, String DOB,String classes, String userName, String password) {
		super(firstName, lastName, gender, address1, address2, city, homeTelephone, mobile, DOB, userName, password);
		// TODO Auto-generated constructor stub
		
		this.parent_guardian=parent_guardian;
		this.classes=classes;
	
	}

	public String getParent_guardian() {
		return parent_guardian;
	}

	public void setParent_guardian(String parent_guardian) {
		this.parent_guardian = parent_guardian;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		super.toString();
		return "Student [parent_guardian=" + parent_guardian + ", classes=" + classes + "]";
	}



}
