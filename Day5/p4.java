package Day5;

import java.util.Scanner;

public class p4 {
//17. Calculate Simple Interest
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter principal amount: ");
	        double principal = scanner.nextDouble();
	        System.out.print("Enter rate of interest: ");
	        double rate = scanner.nextDouble();
	        System.out.print("Enter time in years: ");
	        double time = scanner.nextDouble();
	        double interest = (principal * rate * time) / 100;
	        System.out.println("Simple Interest: " + interest);
	        scanner.close();
	    }
	}