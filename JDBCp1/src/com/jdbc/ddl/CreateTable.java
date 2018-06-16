package com.jdbc.ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try {
			// create Connection
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			// create command-statement
			stmt = con.createStatement();

			// execute command
			boolean b = stmt.execute("CREATE TABLE TEST_EMPLOYEE (PID NUMBER,NAME VARCHAR,SALARY DOUBLE)");
			if (b == false) {
				System.out.println("Table Created");
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
