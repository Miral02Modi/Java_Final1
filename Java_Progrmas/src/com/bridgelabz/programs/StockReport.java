package com.bridgelabz.programs;

import java.util.Scanner;
import java.util.LinkedList;

class StockReport {
	static Scanner scr = new Scanner(System.in);

	public static void main(String args[]) {
		StockReport st = new StockReport();
		

		Stock str[] = st.input();
		System.out.println("Enter your Stock Name");
		String name = scr.next();
		Util1.stockPrice(str, name);
		scr.close();
	}

	Stock[] input() {
		Scanner scr = new Scanner(System.in);
		System.out.print("Enter The Number Of Stock");
		int num = scr.nextInt();
		Stock st[] = new Stock[num];

		for (int i = 0; i < num; i++) {
			st[i] = new Stock();
			st[i].setId(i);
			System.out.println("Enter The Stock Name");
			String name = scr.next();
			st[i].setName(name);
			System.out.println("Enter The Stock price");
			st[i].setPrice(scr.nextInt());
			System.out.println("Enter The Number of Share");
			st[i].setnumShare(scr.nextInt());
		}
		return st;
	}
}
