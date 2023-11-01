package com.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "12345678");
				Statement stm = con.createStatement();
				Statement stm2 = con.createStatement();) {

			//  ----------------- BATCH ------------------------
			stm.addBatch("INSERT INTO account values(5,'pal','nabi',10000)");
			stm.addBatch("INSERT INTO account values(15,'bal','nabi',15000)");
			stm.addBatch("INSERT INTO account values(50,'ktta','nabi',20000)");
			int[] result = stm.executeBatch();
			for (int i : result) {
				System.out.println(i);
			}


			// ------------------RESULT META DATA --------------------
			ResultSet result2 = stm2.executeQuery("SELECT * FROM account");
			ResultSetMetaData metaResult2 = result2.getMetaData();
			int columnCount = metaResult2.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(metaResult2.getColumnName(i));
				System.out.println(metaResult2.getColumnTypeName(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

// https://medium.com/geekculture/distributed-transactions-two-phase-commit-c82752d69324