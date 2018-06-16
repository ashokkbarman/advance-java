package com.jdbc.dml.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingPreparedStmtAndBatch {

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")){
			
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO PERSON VALUES(?,?,?) ");
			
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

				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setDouble(3, sal);
				
				pstmt.addBatch();
				
				System.out.println("Do you want Continue:");
				choice = sc.nextLine();

			}
			int a[] = pstmt.executeBatch();
			System.out.println(a.length +"-Record Inserted Succeffully using PreparedStatement");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
