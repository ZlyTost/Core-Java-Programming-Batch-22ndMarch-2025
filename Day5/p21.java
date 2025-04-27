package Day5;

import java.util.Scanner;

public class p21 {
//11. Print Prime Numbers in a Range
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the lower bound: ");
	        int lower = scanner.nextInt();
	        System.out.print("Enter the upper bound: ");
	        int upper = scanner.nextInt();
	        System.out.println("Prime numbers between " + lower + " and " + upper + ":");
	        for (int i = lower; i <= upper; i++) {
	            boolean isPrime = true;
	            if (i < 2) isPrime = false;
	            for (int j = 2; j <= Math.sqrt(i); j++) {
	                if (i % j == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	            if (isPrime) {
	                System.out.print(i + " ");
	            }
	        }
	        System.out.println ();
	        scanner.close();
	    }
	}