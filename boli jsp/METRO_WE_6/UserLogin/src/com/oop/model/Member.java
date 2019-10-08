//@author vidula IT18026962
package com.oop.model;

public class Member {

	private String memberID;
	private String firstName;
	private String lastName;
	private String gender;
	private String address1;
	private String address2;
	private String city;
	private String homeTelephone;
	private String mobile;
	private String DOB;
	private String userName;
	private String password;
	
	/*constructor formed*/
	public Member(String firstName,String lastName,String gender,String address1,String address2,String city,String homeTelephone,String mobile,String DOB,String userName,String password)
	{	
	
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.homeTelephone=homeTelephone;
		this.mobile=mobile;
		this.DOB=DOB;
		this.userName=userName;
		this.password=password;
	}
	
	
	/* Getters and setters generated*/
	
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getHomeTelephone() {
		return homeTelephone;
	}


	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMemberID() {
		return memberID;
	}

	
	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", firstName=" + firstName + ", lastName=" + lastName + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", gender=" + gender + ", homeTelephone="
				+ homeTelephone + ", mobile=" + mobile + ", DOB=" + DOB + ", userName=" + userName + ", password="
				+ password + "]";
	}

	

}
