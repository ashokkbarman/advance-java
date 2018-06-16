package com.jdbc.dml.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUsingStamentAndBatch {

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")){
			
			Statement stmt = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			String choice = "Y";

			while (choice.equalsIgnoreCase("y")) {
				System.out.println("Please enter your data");
				System.out.println("ID:");
				int id = Integer.parseInt(sc.nextLine());

				System.out.println("Name:");
				String name = sc.nextLine();

				System.out.println("Salary:");
				double sal = Double.parseDouble(sc.nextLine());

				// JDBC code

				stmt.addBatch("INSERT INTO PERSON VALUES(" + id + ", '" + name + "'," + sal + ")");
				
				System.out.println("Do you want Continue:");
				choice = sc.nextLine();

			}
			int a[] = stmt.executeBatch();
			System.out.println(a.length +" -Record Inserted Succeffully using Statement");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
