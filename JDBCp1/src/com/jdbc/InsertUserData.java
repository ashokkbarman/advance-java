package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUserData {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try {

			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			stmt = con.createStatement();

			Scanner sc = new Scanner(System.in);
			String choice = "Y";

			while (choice.equalsIgnoreCase("y")) {
				System.out.println("Please enter your data");
				System.out.println("ID:");
				String id1 = sc.nextLine();

				System.out.println("Name:");
				String name = sc.nextLine();

				System.out.println("Salary:");
				String sal1 = sc.nextLine();

				int id = Integer.parseInt(id1);
				double sal = Double.parseDouble(sal1);

				int i = stmt.executeUpdate("INSERT INTO PERSON VALUES(" + id + ", '" + name + "'," + sal + ")");
				if (i > 0) {
					System.out.println("Record Inserted Successfully");
				}

				System.out.println("Do you want Continue:");
				choice = sc.nextLine();

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
