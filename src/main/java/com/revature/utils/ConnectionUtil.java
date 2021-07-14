package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		
		
		//registers the driver
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://java-react-210614.c0s9xp4n8th0.us-east-2.rds.amazonaws.com/project0";
		String username = "postgres";
		String password = "password1";
		return DriverManager.getConnection(url, username, password);
		
	}

}
