/**
 * 
 */
package com.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author manan
 *
 */
public class ConnectionUtility {

	public static Connection getDerbyConnection() {
		
		Connection derbyConnection=null;
					
		String url = "jdbc:derby:D:\\Database\\CodeFuryDB;create=true";
        String user = "admin";
        String password = "password";
        
        try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			derbyConnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("CONNECTION FAILED.");
		}
		
		if (derbyConnection != null) {
	           System.err.println("CONNECTION ESTABLISHED.");
	    }
			
		return derbyConnection;
	}
}
