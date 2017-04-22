package com.bridgelabz.programs;

import java.util.Scanner;
public class Factor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the integer number");
		if (scanner.hasNextInt()) {
			int N = scanner.nextInt();
			System.out.println("Prime factors for given number are :");
			for (int i = 2; i <= N / 2; i++) {
				if ((Util1.checkFact(N, i)) && (Util1.chckPrime(i))) {
					System.out.print(i + "\t");
				}
			}
		} else {
			System.out.println("Enter integers only");
			main(args);
		}
		scanner.close();
	}
}
