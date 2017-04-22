package com.bridgelabz.programs;

import java.util.Scanner;

public class Harmonic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Number::");
		if (scanner.hasNextInt()) {
			double number = scanner.nextDouble();
			System.out.println(Util1.harmonic(number));
		} else {
			System.out.println("Enter the integer Only");
			main(args);
		}

	}
}
