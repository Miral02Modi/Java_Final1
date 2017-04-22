package com.bridgelabz.programs;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Pelindrom checker
 * 
 * @author Miral
 *
 */
public class PelindromJava {

	public static void main(String[] args) {

		ArrayDeque<Character> q1 = new ArrayDeque<Character>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String::");
		if (sc.hasNext()) {
			String str = sc.next();

			int len = str.length() / 2;
			int i = 0;
			for (; i < str.length() / 2; i++)
				q1.add(str.charAt(i));

			Util1.pelindromCheck(str, q1);
		} else
			System.out.println("Enter String only");
	}
	/*
	 * static public void peliCheck(String str,ArrayDeque q1){ for (int j =
	 * str.length()-1; j > (str.length() / 2) ; j--) { if ((Character)q1.peek()
	 * == str.charAt(j)) q1.poll(); else break; } if (q1.size() == 0 ||
	 * q1.size() == 1) System.out.println("It is pelindrom"); else
	 * System.out.println("It isnot pelindrom"); }
	 */
}
