package com.bridgelabz.programs;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Array1 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter The rows::");
		int rows = scanner.nextInt();
		System.out.print("Enter The cols::");
		int cols = scanner.nextInt();
		Util1.d2Array(rows, cols);
	}
}
