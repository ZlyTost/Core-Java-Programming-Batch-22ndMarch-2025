package Day4;

import java.util.Scanner;

public class p4 {
//4. Prime Number Check
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        boolean isPrime = true;
	        for (int i = 2; i <= Math.sqrt(number); i++) {
	            if (number % i == 0) {
	                isPrime = false;
	                break;
	            }
	        }
	        if (isPrime && number > 1) {
	            System.out.println(number + " is a prime number.");
	        } else {
	            System.out.println(number + " is not a prime number.");
	        }
	        scanner.close();
	    }
	}