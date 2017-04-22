package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class UnOrderList {
	public static void main(String[] args) {
		System.out.println("------------------------");
		FileReader fr = new FileReader();
		String s1 = "";
		
		try {
			s1 = fr.reader("src/txtFile/Demo.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str[] = s1.split(" ");
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < str.length; i++)
			list.add(str[i]);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String::");
		String ip = sc.next();

		if (list.contains(ip)) {
			list.remove(ip);
		} else {
			list.add(ip);
		}
		s1 = "";
		for (String s2 : list)
			s1 = s1 + s2 + " ";
		FileWriter fw = new FileWriter();
		try {
			fw.writer(s1,"src/txtFile/Demo.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------");
	}
}
