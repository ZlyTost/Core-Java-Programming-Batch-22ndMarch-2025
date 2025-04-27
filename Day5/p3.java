package Day5;

import java.util.Scanner;

public class p3 {
//16. Find the Largest Digit in a Number
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        int largestDigit = 0;
	        while (number != 0) {
	            int digit = number % 10;
	            if (digit > largestDigit) {
	                largestDigit = digit;
	            }
	            number /= 10;
	        }
	        System.out.println("Largest digit is: " + largestDigit);
	        scanner.close();
	    }
	}