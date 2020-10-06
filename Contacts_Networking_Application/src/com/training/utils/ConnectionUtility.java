package com.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	public static Connection getDerbyConnection() {
		
		Connection derbyConnection = null;
		
		
		try {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String derbyURL = "jdbc:derby:NetworkDB;create=false";
			
			derbyConnection = DriverManager.getConnection(derbyURL);
			
			if (derbyConnection != null) {
				System.out.println("Connection Established");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return derbyConnection;
	}
}
