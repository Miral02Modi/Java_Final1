package com.bridgelabz.programs;

class Insertion {
	public static void main(String args[]) {
		String str = "hello welcome to java world";
		String ch[] = Util1.insertionSortStr(str.split(" "));
		for (int i = 0; i < ch.length; i++)
			System.out.println(ch[i]);
	}
}
