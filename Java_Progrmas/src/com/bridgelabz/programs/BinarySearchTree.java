package com.bridgelabz.programs;

import java.util.Scanner;

public class BinarySearchTree {

	public static void main(String[] args) {
		
		System.out.println("Number of the Nodes::");
		Scanner numNode = new Scanner(System.in);
		long node = 0;
		
		if (numNode.hasNextInt()) {
			node = numNode.nextInt();
			System.out.println("Number of Node is::" + Math.round(catlanNum(node)));
		} else{
			System.err.println("Enter the Integer only");
			main(args);
		}
		
	}

	/*catlan number counting*/
	static double catlanNum(double numNode) {
		double facto = factorial(2 * numNode);
		double facto1 = factorial(numNode + 1);
		double facto2 = factorial(numNode);
		double numTree = facto / (facto1 * facto2);
		return numTree;
	}
	
	/*factorial number count*/
	static double factorial(double num) {
		double fact = 1;
		for (double i = 1; i <= num; i++) {
			fact = fact * i;
		}
		return fact;
	}
}
