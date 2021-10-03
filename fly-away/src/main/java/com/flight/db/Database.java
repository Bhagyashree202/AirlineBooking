package com.flight.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public static Connection getConnection(){ 
		Connection connection = null;
		try
		{  
			String driverName = "com.mysql.cj.jdbc.Driver";
		    String connectionUrl = "jdbc:mysql://localhost/ticketing";
		    String userId = "rmf_admin";
		    String password = "admin@rmf2021";
		    try {
		        Class.forName(driverName);
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
		    connection = DriverManager.getConnection(connectionUrl, userId, password);  
            
            if(null!=connection)
            	System.out.println("Connected to DB");
		}catch (Exception err) {
			  System.out.println("ERROR: " + err);  
		}
		return connection;
	}
}
