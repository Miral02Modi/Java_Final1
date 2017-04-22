package com.bridgelabz.programs;


public class Bank_Counter {
	
	String userName;
	int id;
	double salary;
	static double totalAmt = 1000000;
	public Bank_Counter(String uname, int id, double amt) {
		super();
		userName = uname;
		this.id = id;
		this.salary = amt;
	}
	public String getuName() {
		return userName;
	}
	public void setuName(String uName) {
		this.userName = uName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSal() {
		return salary;
	}
	public void setSal(double sal) {
		this.salary = sal;
	}
	public static double getTotalAmt() {
		return totalAmt;
	}
	public static void setTotalAmt(double totalAmt) {
		Bank_Counter.totalAmt = totalAmt;
	}
	
	public double widthDrawal(double amt){
		if(this.salary < amt){
			System.out.println("Your Balance is less");
			return this.salary;
		}	
		if(this.totalAmt < amt){
			System.out.println("Sry No cach is Avilable");
			return 0;
		}	
		this.salary = this.salary - amt ;
		this.totalAmt = this.totalAmt -amt;
		return this.salary;
	}
	
	public double deposite(double amt){
		if(amt < 10000){
			System.out.println("You have to deposite mininmum 10000");
			return 0;
		}	
		this.salary = this.salary + amt ;
		this.totalAmt = this.totalAmt + amt;
		return this.salary;
	}
}
