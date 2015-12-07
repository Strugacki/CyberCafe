package com.ug.cyberCafe.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {
	
	private Connection conn;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	public ConnectionConfiguration()	{
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Connection problem occured. Please restart the application");
			e.printStackTrace();
		}
		
	}

	public Connection getConnection() {
		return conn;
	}	
}