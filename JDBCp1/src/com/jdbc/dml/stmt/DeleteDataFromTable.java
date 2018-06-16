package com.jdbc.dml.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataFromTable {

	public static void main(String[] args) {

		Statement stmt = null;

		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
			stmt = con.createStatement();

			int i = stmt.executeUpdate("DELETE FROM PERSON WHERE PID=3");
			if (i > 0) {
				System.out.println("Record Deleted  Successfully");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
