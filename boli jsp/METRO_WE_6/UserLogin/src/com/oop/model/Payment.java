package com.oop.model;

import java.util.ArrayList;

public class Payment {
	
	private String memberID;
	private int payID; // auto generated
	private String payFor;
	private String payMethod;
	private int cardNumber;
	private String bank;
	private double amount;
	private double Fee;
	private double exCur;
	private double additional;
	
	
	
	
	public double getFee() {
		return Fee;
	}
	public void setFee(double fee) {
		Fee = fee;
	}
	public double getExCur() {
		return exCur;
	}
	public void setExCur(double exCur) {
		this.exCur = exCur;
	}
	public double getAdditional() {
		return additional;
	}
	public void setAdditional(double additional) {
		this.additional = additional;
	}
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getPayID() {
		return payID;
	}
	public void setPayID(int payID) {
		this.payID = payID;
	}
	public String getPayFor() {
		return payFor;
	}
	public void setPayFor(String payFor) {
		this.payFor = payFor;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}

