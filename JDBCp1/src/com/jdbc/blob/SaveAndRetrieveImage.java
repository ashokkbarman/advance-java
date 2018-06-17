package com.jdbc.blob;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveAndRetrieveImage {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
//			save
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO TEST_IMAGE VALUES(?,?)");
			FileInputStream fin = new FileInputStream("F://icamps//advanceJava-atulSir//advance-java//JDBCp1//src//image/input-imgae.jpg");

			pstmt.setString(1, "Rose-New");
			pstmt.setBinaryStream(2, fin, fin.available());

			int i = pstmt.executeUpdate();

			if (i > 0) {
				System.out.println("Image inserted successfully!");
			}
			
			//retrieve 
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT IMAGE FROM TEST_IMAGE WHERE NAME = 'Rose'");
			rs.next();
			
			Blob blob = rs.getBlob(1);
			byte a[] = blob.getBytes(1, (int)blob.length());
			
			FileOutputStream fos = new FileOutputStream("F://icamps//advanceJava-atulSir//advance-java//JDBCp1//src//image/output-image.jpg");
			fos.write(a);
			fos.close();
			

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
