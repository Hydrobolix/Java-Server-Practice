package com.serverpractice;

import java.util.Scanner;

public class Utilities {

	public static String userInput(Scanner scan) {
		String choice = "";
		choice = scan.nextLine();
		
		return choice;
	}
	
	/* User Details */
	
	public static void checkUsername(Scanner scan, String username, int paramLength, UserDetails ud) {
		do {
			username = scan.nextLine();
			
			if (username.length() > paramLength) {
				System.out.println("Username cannot be over " + paramLength + " characters");
			} else {
				ud.setName(username);
			}
		} while (username.length() > paramLength);
	}
	
	public static void checkEmail(Scanner scan, String email, int paramLength, UserDetails ud) {		
		do {
			email = scan.nextLine();
			
			if (email.length() > paramLength) {
				System.out.println("Email cannot be over " + paramLength + " characters");
			} else {
				ud.setEmail(email);
			}
		} while (email.length() > paramLength);
	}
	
	public static void checkContactNumber(Scanner scan, String contactNumber, int paramLength, UserDetails ud) {
		do {
			contactNumber = scan.nextLine();
			
			if (contactNumber.length() > paramLength) {
				System.out.println("Contact number cannot be over " + paramLength + " characters");
			} else {
				ud.setContactNumber(contactNumber);
			}
		} while (contactNumber.length() > paramLength);
	}
	
	/* Login Token */
	
	public static void checkUsername(Scanner scan, String username, int paramLength, LoginToken lt) {		
		do {
			username = scan.nextLine();
			
			if (username.length() > paramLength) {
				System.out.println("Username cannot be over " + paramLength + " characters");
			} else {
				lt.setName(username);
			}
		} while (username.length() > paramLength);
	}
	
	public static void checkPassword(Scanner scan, String password, int paramLength, LoginToken lt) {
		do {
			password = scan.nextLine();
			
			if (password.length() > paramLength) {
				System.out.println("Password cannot be over " + paramLength + " characters");
			} else {
				lt.setPassword(password);
			}
		} while (password.length() > paramLength);
	}
}
