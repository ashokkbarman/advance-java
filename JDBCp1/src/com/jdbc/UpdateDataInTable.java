package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataInTable {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			stmt = con.createStatement();

			int i = stmt.executeUpdate("UPDATE PERSON SET SALARY = 200.06 WHERE PID=2");
			if (i > 0) {
				System.out.println("Record Updated Successfully");
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
