//@author vidula IT18026962
package com.oop.model;

public class Other extends Teacher{

	public Other(String firstName, String lastName, String gender, String address1, String address2, String city,
			String homeTelephone, String mobile, String DOB, String userName, String password, String NIC,
			String rClass) {
		super(firstName, lastName, gender, address1, address2, city, homeTelephone, mobile, DOB, userName, password, NIC,
				rClass);
		// TODO Auto-generated constructor stub
	}
	
	public void setMemberID(String otherID)
	{
		super.setMemberID(otherID);
	}
	
	public String getMemberID()
	{
		return super.getMemberID();
	}



}
