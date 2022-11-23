package com.database.connection.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{

	final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	final String DB_USERNAME = "root";
	final String DB_PASSWORD = "Sush@123";
	final String DB_URL = "jdbc:mysql://localhost:3306/crud";
	
	Connection connection = null;
	
	public Connection getConnection() 
	{
		try 
		{
			// Loading the driver. not compulsory to write this line.
			Class.forName(DB_DRIVER_CLASS);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
