package com.bridgelabz.programs;

import java.util.Scanner;

public class Vending {

	public static void main(String args[]) {
		int rupee[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		System.out.println("enter the amount");
		Scanner scanner = new Scanner(System.in);
		int amount=0 ;
		if(scanner.hasNextInt())
		amount = scanner.nextInt();
		else{
			System.out.println("Enter the integer value only");
			main(args);
		}
		int sum = amount, temp = 0, count = 0, total_count = 0;
		int i = rupee.length - 1;
		while (sum >= 0 && i >= 0) {
			temp = sum;
			sum = sum % rupee[i];
			if (temp != sum) {
				count = temp / rupee[i];
				total_count = total_count + count;
				System.out.println("the number of  count " + rupee[i] + " of notes" + count);

			}
			i--;
		}
		System.out.println("the total number of  count of notes" + total_count);

	}

}
