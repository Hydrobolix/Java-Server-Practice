package com.serverpractice;

import java.sql.SQLException;
import java.util.Scanner;

public class RegistrationScreen {
	
	UserDetails ud;
	
	public RegistrationScreen() {
		ud = new UserDetails();
		System.out.println("-- Registration Screen --");
	}
	
	public void getUserInput(Scanner scan) {
		String username = "", email = "", contactNumber = "";
		
		System.out.println("Username: ");
		Utilities.checkUsername(scan, username, 30, ud);
		
		System.out.println("Email: ");
		Utilities.checkEmail(scan, email, 30, ud);
		
		System.out.println("Contact Number: ");
		Utilities.checkContactNumber(scan, contactNumber, 15, ud);
	}
	
	public void addtoDB(DBConnector dbConn) throws SQLException {
		if (ud != null) {
			dbConn.addToUsersTable(ud);
		}
		
		System.out.println("Registered has done..!!!");
		System.out.println("Your password is your email with 123 appended, "
						 + "please go to your account settings to change your password.");
	}
}
