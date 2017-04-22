package com.bridgelabz.programs;

import java.util.Scanner;

public class Gamler {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextInt()) {
			System.out.println("Enter your amount");
			int amount = scanner.nextInt();

			System.out.println("Enter The Target goal");
			int goal = scanner.nextInt();

			System.out.println("Howmany time to play");
			double number = scanner.nextDouble();

			double win = (Util1.gamlerPers(number, amount, goal) / number) * 100;
			System.out.println("Winning perentage is::" + Math.round(win) + "%");
			System.out.println("Lossing perentage is::" + (100 - Math.round(win)) + "%");
		} else {
			System.out.println("Enter the valid data");
			main(args);
		}

	}
}
