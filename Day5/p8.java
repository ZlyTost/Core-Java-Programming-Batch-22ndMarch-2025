package Day5;

import java.util.Scanner;

public class p8 {
//21.Print the First N Prime Numbers
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number of prime numbers to print: ");
	        int n = scanner.nextInt();
	        int count = 0, num = 2;
	        while (count < n) {
	            boolean isPrime = true;
	            for (int i = 2; i <= Math.sqrt(num); i++) {
	                if (num % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	            if (isPrime) {
	                System.out.print(num + " ");
	                count++;
	            }
	            num++;
	        }
	        System.out.println();
	        scanner.close();
	    }
	}