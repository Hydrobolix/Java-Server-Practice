package com.serverpractice;

public class UserDetails {
	String name = "";
	String email = "";
	String contactNumber = "";
	
	public UserDetails() { }
	
	public UserDetails(String name, String email, String contactNumber) {
		setName(name);
		setEmail(email);
		setContactNumber(contactNumber);
	}
	
	public UserDetails(UserDetails ud) {
		setName(ud.getName());
		setEmail(ud.getEmail());
		setContactNumber(ud.getContactNumber());
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
