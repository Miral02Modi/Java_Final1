package com.bridgeit.addressbook.testApp;

import java.io.IOException;
import java.util.Scanner;

import com.bridgeit.addressbook.controller.AddressController;
import com.bridgeit.addressbook.service.AddressBookInter;
import com.bridgeit.addressbook.service.AddressImple;

public class AddressBook {

	public static void main(String[] args) {

		AddressController abControl = new AddressController();
		Scanner scanner = new Scanner(System.in);

		for (int i = 0;; i++) {

			System.out.println("\t\t\t\t\t\t\t\t--------------***MENU***----------------\n\n");
			System.out.println("\t\t\t\t1.addPerson      ::");
			System.out.println("\t\t\t\t2.removePerson   ::");
			System.out.println("\t\t\t\t3.update Person  ::");
			System.out.println("\t\t\t\t4.sort By Name   ::");
			System.out.println("\t\t\t\t5.sort By Zipcode::");
			System.out.println("\t\t\t\t6.Full name      ::");
			System.out.println("\t\t\t\t7.Display        ::");
			System.out.println("\t\t\t\t8.Display name   ::");
			System.out.println("\t\t\t\t9.Exit           ::");
			System.out.print("\t\t\t\tEnter The choice ::");
			String choice = scanner.next();

			switch (choice) {

			case "1":
				abControl.addPerson();
				break;

			case "2":
				System.out.println("Enter The index");
				if (scanner.hasNextInt()) {
					abControl.removePerson(scanner.nextInt());
				} else {
					System.out.println("Enter the only integer Number");
					main(args);
				}
				break;

			case "3":
				abControl.updatePerson();
				break;

			case "4":
				abControl.sortByName();
				break;

			case "5":
				abControl.sortByZipcode();
				break;

			case "6":
				abControl.getFullName();
				break;

			case "7":
				abControl.display();
				break;

			case "8":
				System.out.println("Enter the name");
				abControl.display(scanner.next());
				break;

			case "9":
				break;

			default:
				System.out.println("Enter the valid choice");
				break;
			}

			if (choice.equals("9"))
				break;

		}
	}
}
