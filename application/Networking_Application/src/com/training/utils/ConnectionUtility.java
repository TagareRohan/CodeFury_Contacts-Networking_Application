package com.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

public static Connection getDerbyConnection() {
		
		Connection derbyConnection=null;
			
//		create table userTable ( userid INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), username varchar(255) unique not null, password varchar(255) not null, fullName varchar(255) not null, email varchar(255) unique not null, phone bigint unique, gender varchar(255), dateOfBirth date, address varchar(255), city varchar(255), state varchar(255), country varchar(255), company varchar(255), image blob, isdisabled smallint, isdeleted smallint);
		
		String url = "jdbc:derby:D:\\Database\\CodeFuryDB;create=true";
        
        try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			derbyConnection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("CONNECTION FAILED.");
		}
		
		if (derbyConnection != null) {
	           System.err.println("CONNECTION ESTABLISHED.");
	    }
			
		return derbyConnection;
	}
}