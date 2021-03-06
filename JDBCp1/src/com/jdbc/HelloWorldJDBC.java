package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorldJDBC {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON");

			// process ResultSet
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double sal = rs.getDouble(3);
				System.out.println(id + " " + name + " " + sal);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
