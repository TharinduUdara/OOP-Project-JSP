//@author vidula IT18026962
package com.oop.model;

public class Teacher extends Member {
	
	private String NIC;
	private String rClass;
	
	public Teacher(String firstName, String lastName,String gender, String address1, String address2, String city,
			 String homeTelephone, String mobile, String DOB, String userName, String password,String NIC,String rClass) {
		super(firstName, lastName, gender, address1, address2, city, homeTelephone, mobile, DOB, userName, password);
		// TODO Auto-generated constructor stub
		
		this.NIC=NIC;
		this.rClass=rClass;
	}
	
	public String getrClass() {
		return rClass;
	}

	public void setrClass(String rClass) {
		this.rClass = rClass;
	}

	public void setMemberID(String teacherID)
	{
		super.setMemberID(teacherID);
		
	}
	
	public String getMemberID()
	{
		return super.getMemberID();
		
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	@Override
	public String toString() {
		return "Teacher [NIC=" + NIC + ", rClass=" + rClass + "]";
	}

	
	

}
