package com.serverpractice;

public class LoginToken {
	String name = "";
	String password = "";
	
	public LoginToken () { }
	
	public LoginToken (String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public LoginToken(LoginToken lt) {
		setName(lt.getName());
		setPassword(lt.getPassword());
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
}
