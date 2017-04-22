package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OrderList {
	public static void main(String[] args) {
		FileReader fr = new FileReader();
		String str = "";
		try {
			str = fr.reader("src/txtFile/Integer.txt");
		} catch (IOException e) {
			main(args);
		}
		String s1[] = str.split(" ");

		int[] array = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray(); // Lambda
																				// Expression
																				// in
																				// java

		Integer[] newArray = new Integer[array.length];
		int i = 0;
		for (int value : array) {
			newArray[i++] = Integer.valueOf(value);
		}
		newArray = BubbleSort.bubbleSort(newArray);

		List<Integer> list = new LinkedList<Integer>();

		for (int i1 : newArray)
			list.add(i1);

		System.out.println("Enter The Integer Value");
		Scanner scanner = new Scanner(System.in);
		int value = 0;
		if(scanner.hasNextInt()){
		value = scanner.nextInt();
		}else{
			System.out.println("Enter the valid data");
			main(args);
		}
			
		if (list.contains(value)) {
			list.remove(list.indexOf(value));
			Integer arr[] = new Integer[list.size()];
			list.toArray(arr);
			String str1 = "";
			for (Integer i1 : arr)
				str1 = str1 + i1 + " ";
			FileWriter filewriter = new FileWriter();
			try {
				filewriter.writer(str1, "src/txtFile/Integer.txt");
			} catch (IOException e) {
				System.out.println("File not found");
				main(args);
			}
		} else {
			list.add(value);
			Integer arr[] = new Integer[list.size()];
			list.toArray(arr);
			
			arr = BubbleSort.bubbleSort(arr);
			for (int arr1 : arr)
				System.out.println(arr1);
			String str1 = "";
			
			for (Integer i1 : arr)
				str1 = str1 + i1 + " ";
			FileWriter fileWriter = new FileWriter();
			try {
				fileWriter.writer(str1, "src/txtFile/Integer.txt");
			} catch (IOException e) {
				System.out.println("File not found");
				main(args);
			}
		}

	}
}
