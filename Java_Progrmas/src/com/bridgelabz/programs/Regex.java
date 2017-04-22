package com.bridgelabz.programs;

import java.math.MathContext;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {

		Pattern p = Pattern.compile(".<<");// . represents single character
		Matcher m = p.matcher("a<<");
		boolean b = m.matches();

		String mstr = "Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx."
				+ "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016. ";

		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		boolean flag = true;

		System.out.print("Enter The your name::");
		String name = scanner.next();
		Pattern pattern = Pattern.compile("<<name>>");
		Matcher matcher = pattern.matcher(mstr);
		if (matcher.find()) {
			mstr = mstr.replace(mstr.substring(matcher.start(), matcher.end()), name);
		}

		pattern = Pattern.compile("<<full name>>");
		matcher = pattern.matcher(mstr);
		System.out.print("Enter The full name::");
		String fullName = scanner1.nextLine();
		if (matcher.find()) {
			mstr = mstr.replace(mstr.substring(matcher.start(), matcher.end()), fullName);
		}

		System.out.print("Enter your number::");
		pattern = Pattern.compile("xxxxxxxxxx");
		String num = scanner1.next();
		matcher = pattern.matcher(mstr);
		if (matcher.find()) {
			mstr = mstr.replace(mstr.substring(matcher.start(), matcher.end()), num);
		}

		System.out.print("Enter your Date::");
		pattern = Pattern.compile("01/01/2016");
		String date = scanner1.next();
		matcher = pattern.matcher(mstr);
		if (matcher.find()) {
			mstr = mstr.replace(mstr.substring(matcher.start(), matcher.end()), date);
			System.out.println(mstr);
		}
	}
}
