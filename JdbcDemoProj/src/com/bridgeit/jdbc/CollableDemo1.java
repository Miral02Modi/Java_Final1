package com.bridgeit.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CollableDemo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=ninja");
			CallableStatement callableStatement = con.prepareCall("{call getMobileNumber(?,?,?,?)}");
			System.out.println("Enter the emailId");
			callableStatement.setString(2, scanner.next());
			System.out.println("Enter the password");
			callableStatement.setString(1, scanner.next());
			callableStatement.executeQuery();
			String user = callableStatement.getString(3);
			String mobileNumber = callableStatement.getString(4);
			System.out.println(user);
			System.out.println(mobileNumber);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("success");

	}
}
