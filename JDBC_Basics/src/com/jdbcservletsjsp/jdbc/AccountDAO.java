package com.jdbcservletsjsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	private static int numberOfRowsAffected;

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "12345678");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM account");) {

			System.out.println(connection);

			// numberOfRowsAffected = statement.executeUpdate("INSERT INTO account
			// VALUES(1,'nabajyoti','modak',1000)");

			// numberOfRowsAffected = statement.executeUpdate("UPDATE account SET
			// lastname='Papai' WHERE accno=2");

			// numberOfRowsAffected = statement.executeUpdate("DELETE FROM account WHERE
			// accno=1");

			// System.out.println(numberOfRowsAffected);

			while (resultSet.next()) {
				System.out.println(resultSet.getString(2) + resultSet.getString(3) + resultSet.getInt(4));
			}

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
