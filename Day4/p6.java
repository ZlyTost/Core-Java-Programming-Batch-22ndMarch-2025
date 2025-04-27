package Day4;

import java.util.Scanner;

public class p6 {
//6. Reverse a Number
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        int reversed = 0;
	        while (number != 0) {
	            reversed = reversed * 10 + number % 10;
	            number /= 10;
	        }
	        System.out.println("Reversed number is: " + reversed);
	        scanner.close();
	    }
	}