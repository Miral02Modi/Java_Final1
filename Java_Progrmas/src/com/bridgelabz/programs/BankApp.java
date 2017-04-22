package com.bridgelabz.programs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ArrayDeque<Bank_Counter> queue = new ArrayDeque<>();
		System.out.println("Enter The Number of user in queue");
		int length=0;
		if(scanner.hasNextInt())
			length = scanner.nextInt();
		else{
			System.out.println("Enter the Integer value");
			main(args);
		}
		int id = 0;
		double salary = 0;
		
		for (int i = 0; i < length; i++) {
			System.out.print("Enter The Name::");
			String name = scanner.next();
			System.out.print("Enter The id::");
			if (scanner.hasNextDouble()) {
				id = scanner.nextInt();
					System.out.print("Enter The sal::");
				if (scanner.hasNextInt())
					salary = scanner.nextInt();
				else {
					System.out.println("Enter the integer value");
					main(args);
				}
			} else {
				System.out.println("Enter the integer value");
				main(args);
			}
			queue.add(new Bank_Counter(name, id, salary));
		}

		Util1.bankCase(queue, length);
	}

}
