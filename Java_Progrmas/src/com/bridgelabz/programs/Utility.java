package com.bridgelabz.programs;

import java.util.Scanner;

class Utility {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int arr[] = { 1, 4, 3, 5, 2 };
		arr = Util1.insertionSort(arr);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		arr = Util1.bubbleSortInt(arr);
		System.out.println(Util1.binarySearchInt(arr, 3));
		
		
		String str = "hello welcome to java world";
		String ch[] = Util1.insertionSortStr(str.split(" "));
		for (int i = 0; i < ch.length; i++)
			System.out.println(ch[i]);
		char ch1[] = Util1.bubbleSortString(str);
		
	
		System.out.println("Enter the String");
		String srchString = scanner.next();
		System.out.println(Util1.binarySearchString1(str.split(" "),srchString));

	}
}
