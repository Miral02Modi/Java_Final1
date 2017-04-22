package BalancedParamthesis;

import java.util.Scanner;
class Aclass{
	static{
		System.out.println("Hello Aclass");
	}
}

public class BalancePara {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Expression");
		String str = sc.next();
		Util.balancePara(str);
		Util.isPresent(0,8,2);
	}
	
	/*static void balancePara(String str) {
		StackDemo sd = new StackDemo(str.length());

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(')
				sd.push(ch);
			else if (ch == ')')
				sd.pop();
		}

		if (sd.isEmpty())
			System.out.println("Parathesis is Balanced");
		else
			System.out.println("Parathesis is not Balanced");
	}*/

}
