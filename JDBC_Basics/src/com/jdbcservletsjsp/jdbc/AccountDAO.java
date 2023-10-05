package com.jdbcservletsjsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccountDAO {

    public static void main(String[] args) {
	try {
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
	    System.out.println(connection);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}

/*
 * connection string:- protocol//user:pass@url//database?props
 * 
 * Service Provider Interface (SPI) - java.sql.Driver
 * 
 * Service Provider - com.mysql.cj.jdbc.Driver
 * 
 * The ServiceLoader class is used to locate service providers.
 * 
 * ServiceLoader class scans the META-INF/services/java.sql.Driver & loads the
 * service provider
 * 
 * Inside static initializer block of Service provider class, the driver
 * registers itself with the DriverManager using the
 * DriverManager.registerDriver()
 * 
 * When you call DriverManager.getConnection(), the DriverManager iterates
 * through the registered drivers. Each driver's acceptsURL() method is called
 * to check if it can handle the provided database URL. If a driver matches the
 * URL, it is selected for establishing the connection
 */
