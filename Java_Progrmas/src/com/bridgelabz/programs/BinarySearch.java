package com.bridgelabz.programs;

import java.io.FileInputStream;
import java.util.Scanner;

class BinarySearch {
	public static void main(String args[]) {
		String strTemp = "";
		try {
			FileInputStream fileInputStream = new FileInputStream("/home/bridgeit/workspace/JavaProject/src/Demo.txt");
			int value = 0;
			while ((value = fileInputStream.read()) != -1) { // read() return -1 if the data is
												// not found other then it
												// retuen byte
				strTemp = strTemp + (char) value;
			}
			System.out.println(strTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String charArr[] = Util1.bubbleSortString1(strTemp);
		System.out.println();
		System.out.println("Enter The String");
		Scanner scanner = new Scanner(System.in);
		String srchString = scanner.next();
		
		if(Util1.binarySearchString1(charArr,srchString))
			System.out.println("Enter the data present");
		else
			System.out.println("Data is not present");
	}
	
}
