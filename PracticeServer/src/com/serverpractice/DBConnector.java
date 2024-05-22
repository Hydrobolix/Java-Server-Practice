package com.serverpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	Connection conn;
	Statement st;
	ResultSet rs;
	
	public DBConnector() { }
	
	public void connectToDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/testdb", "username", "private");
		checkConnection();
		st = conn.createStatement();
	}
	
	public void checkConnection() {
		if (conn != null)
			System.out.println("Connected successfully\n");
		else
			System.out.println("Did not connect successfully");
	}
	
	public void createDBTable() throws SQLException {
		String connect = "create table Users (id int, name varchar(30), email varchar(30), contactNumber varchar(15), password varchar(20))";
		st.execute(connect);
		System.out.println("Table created succesffuly");
	}
	
	public void seedDBTable() throws SQLException {
		String seed = "insert into Users values "
					+ "(0, 'Tyrone', 'tyrone@gmail.com', '4043010223', 'password1'),"
					+ "(1, 'redacted', 'redacted@gmail.com', '4041121113', 'password2'),"
					+ "(2, 'redacted2', 'redacted2@gmail.com', '4040112110', 'password3')";
		
		st.execute(seed);
		System.out.println("Table seeded successfully");
	}
	
	public void addToUsersTable(UserDetails ud) throws SQLException {
		int hash = (int) (Math.random() * 100000);
		
		//idChecker
		
		String addToTable = "insert into Users values "
							  + "(" + hash + ", '" + ud.getName() + "', '" + ud.getEmail() + "', '" + ud.getContactNumber() + "', '" + ud.getEmail() + "123')";
		
		st.execute(addToTable);
	}
	
	public void viewDB() throws SQLException {
		String viewdb = "select * from Users";
		rs = st.executeQuery(viewdb);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + ", " 
							 + rs.getString(2) + ", "
							 + rs.getString(3) + ", "
							 + rs.getString(4) + ", "
							 + rs.getString(5));
			System.out.println("---------");
		}
	}
	
	public boolean checkUserExists(LoginToken lt) throws SQLException {
		boolean userExists = false;
		
		String viewuser = "select name, password from Users "
				+ "where name='" + lt.getName() + "' and password='" + lt.getPassword() + "'";
		
		rs = st.executeQuery(viewuser);
		
		while (rs.next()) {
			if (rs != null && (rs.getString(1).equals(lt.getName()) && rs.getString(2).equals(lt.getPassword()))) {
				userExists = true;
			}
		}
		
		return userExists;
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
}
