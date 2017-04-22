package com.bridgelabz.programs;

public class Power_oF_2 {

	public static void main(String[] args) {

		String str = args[0];
		int pow = Integer.parseInt(str);

		if (pow >= 0 && pow < 31)
			System.out.println("Power Of Two is::" + Math.pow(2, pow));
		else
			System.out.println("Power must be between 0 and 31");
	}
}
