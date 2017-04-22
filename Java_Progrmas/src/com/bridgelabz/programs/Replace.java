package com.bridgelabz.programs;

import java.util.Scanner;

public class Replace {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String str = "Hello username how are you";
		System.out.println(str.replaceAll("username", str));
	}
}
