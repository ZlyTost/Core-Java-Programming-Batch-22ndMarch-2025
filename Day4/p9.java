package Day4;

import java.util.Scanner;

public class p9 {
//9. Palindrome Check
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        String reversed = new StringBuilder(input).reverse().toString();
	        if (input.equals(reversed)) {
	            System.out.println(input + " is a palindrome.");
	        } else {
	            System.out.println(input + " is not a palindrome.");
	        }
	        scanner.close();
	    }
	}