package com.bridgelabz.programs;

import java.util.Scanner;

class FindNumber {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The two to the Power");
		if (scanner.hasNextInt()) {
			int range = scanner.nextInt();
			int pow = (int) Math.pow(2, range);
			System.out.println("Assume One Number please between 1 to " + pow);
			Util1.isPresent(0, pow, range - 1);
		} else {
			System.out.println("Enter the integer value");
			main(args);
		}
	}
}
