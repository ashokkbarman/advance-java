package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataInTable {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try {
			// create Connection
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			// create command-statement
			stmt = con.createStatement();

			// execute command
			int i = stmt.executeUpdate("INSERT INTO PERSON VALUES(2,'Neeraj',100.05)");
			if (i > 0) {
				System.out.println("Record Inserted Successfully");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}
