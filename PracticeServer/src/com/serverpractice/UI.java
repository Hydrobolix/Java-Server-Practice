package com.serverpractice;

import java.sql.SQLException;
import java.util.Scanner;

public class UI {
	DBConnector dbConn;
	Scanner scan;
	
	public UI() {
		try {
			scan = new Scanner(System.in);
			dbConn = new DBConnector();
			
			connect();
			menu();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void connect() throws ClassNotFoundException, SQLException {
		dbConn.connectToDB();
	}
	
	public void displayMenu() {
		System.out.println("-- User App --");
		System.out.println("[A] User Register");
		System.out.println("[B] User Login");
	}
	
	public void menu() throws SQLException {
		displayMenu();
		
		switch (Utilities.userInput(scan)) {
		case "A":
			RegistrationScreen rs = new RegistrationScreen();
			rs.getUserInput(scan);
			rs.addtoDB(dbConn);
			break;
		case "B":
			LoginScreen ls = new LoginScreen();
			ls.getUserInput(scan);
			ls.checkLoginToken();
			ls.logIn(dbConn);
		}
		
		disconnect();
	}
	
	public void disconnect() throws SQLException {
		dbConn.closeConnection();
		scan.close();
	}
}
