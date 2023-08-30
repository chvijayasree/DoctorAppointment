package com.amdocs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {	
	private final static String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost:3306/amdocs_db";
	private final static String USERNAME="root";
	private final static String PASSWORD="Sowkya@123";
	
	private static Connection connection=null;
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_CLASS);

			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection Success....");
		} 
		catch (ClassNotFoundException e) {
	        System.err.println("JDBC Driver Not Found...");
	        e.printStackTrace();
	    }
		catch (SQLException e) {
			System.err.println("Connection Not Established...");
//			System.err.print(e);
			e.printStackTrace();
		}
		return connection;
	}
}

