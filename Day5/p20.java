package Day5;

import java.util.Scanner;

public class p20 {
//10. Find GCD of Two Numbers
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter first number: ");
	        int a = scanner.nextInt();
	        System.out.print("Enter second number: ");
	        int b = scanner.nextInt();
	        while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	        System.out.println("GCD is: " + a);
	        scanner.close();
	    }
	}