package Day4;

import java.util.Scanner;

public class p5 {
//5. Sum of Digits
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        int sum = 0;
	        while (number != 0) {
	            sum += number % 10;
	            number /= 10;
	        }
	        System.out.println("Sum of digits is: " + sum);
	        scanner.close();
	    }
	}