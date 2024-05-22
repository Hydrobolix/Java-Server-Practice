package com.serverpractice;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginScreen {
	
	LoginToken lt;
	
	public LoginScreen() {
		lt = new LoginToken();
		System.out.println("-- Login Screen --");
	}
	
	public void getUserInput(Scanner scan) {
		String username = "", password = "";
		
		System.out.println("Username: ");
		Utilities.checkUsername(scan, username, 30, lt);
		
		System.out.println("Password: ");
		Utilities.checkPassword(scan, password, 20, lt);
	}
	
	public void checkUserInput() {
		if (lt != null) {
			System.out.println("Logging in. ");
		} else {
			System.err.println("LoginToken is empty");
		}
	}
	
	public void logIn(DBConnector dbConn) throws SQLException {
		if (dbConn.checkUserExists(lt))
			System.out.println("Login Successful!");
		else
			System.out.println("The username or password entered is incorrect.");
	}
}
