package com.bridgeit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class createStatement {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the student EmailID::");
		String emailId = scanner.next();
		System.out.print("Enter the password       ::");
		String password = scanner.next();
		String query = "Select * from Student.sudentLogin where emailid=? and password=?";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=ninja");

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			resulSet = preparedStatement.executeQuery();

			
			boolean status=false;
			while (resulSet.next()) {
				
				String user = resulSet.getString("emailId");
				if (user.equalsIgnoreCase(emailId)) {
					String getPassword = resulSet.getString("password");
					
					if (getPassword.equalsIgnoreCase(password)) {

						System.out.println("Login successfully");
						System.out.println("Student name is::" + resulSet.getString("studentname"));
						System.out.println("Student mobile number::" + resulSet.getString("mobilenumber"));
						status=true;
					} 
				}
			}
			
			if(!status)
				System.out.println("UserName or password is wrong::");
		} catch (ClassNotFoundException e) {
			System.out.println("Connection is not estavlish::");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			
			if (resulSet != null) {
				try {
					resulSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}