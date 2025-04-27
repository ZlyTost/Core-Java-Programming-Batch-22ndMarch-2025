package Day5;

import java.util.Scanner;

public class p22 {
//12. Sum of Even and Odd Numbers
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number of elements: ");
	        int n = scanner.nextInt();
	        int evenSum = 0, oddSum = 0;
	        System.out.println("Enter " + n + " numbers:");
	        for (int i = 0; i < n; i++) {
	            int number = scanner.nextInt();
	            if (number % 2 == 0) {
	                evenSum += number;
	            } else {
	                oddSum += number;
	            }
	        }
	        System.out.println("Sum of even numbers: " + evenSum);
	        System.out.println("Sum of odd numbers: " + oddSum);
	        scanner.close();
	    }
	}