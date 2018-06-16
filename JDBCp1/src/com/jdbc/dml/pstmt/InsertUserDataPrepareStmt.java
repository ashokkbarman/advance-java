package com.jdbc.dml.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUserDataPrepareStmt {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {

			PreparedStatement psmt = con.prepareStatement("UPDATE PERSON SET NAME = ? WHERE PID = ?");

			Scanner sc = new Scanner(System.in);
			String choice = "Y";

			while (choice.equalsIgnoreCase("y")) {
				System.out.println("Please enter your data");
				System.out.println("ID:");
				int id = Integer.parseInt(sc.nextLine());

				System.out.println("Name:");
				String name = sc.nextLine();

				// JDBC code

				psmt.setInt(2, id);
				psmt.setString(1, name);

				int i = psmt.executeUpdate(); // No Argument
				if (i > 0) {
					System.out.println("Record Updated Successfully");
				}

				System.out.println("Do you want Continue:");
				choice = sc.nextLine();

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
