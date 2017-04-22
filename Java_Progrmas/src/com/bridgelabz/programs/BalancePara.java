package com.bridgelabz.programs;
import com.bridgelabz.util.*;

import java.util.Scanner;
class Aclass{
	static{
		System.out.println("Hello Aclass");
	}
}

public class BalancePara {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Expression");
		String str = scanner.next();
		Util1.balanceParanthesis(str);
	}
}
