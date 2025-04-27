package Day5;

import java.util.Scanner;

public class p10 {

	 public static void main(String[] args) {
	        // Create a Scanner object to read input
	        Scanner scanner = new Scanner(System.in);
	        
	        // Prompt the user for input
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        
	        // Print the ASCII values of each character in the string
	        System.out.println("ASCII values of characters in the string:");
	        for (int i = 0; i < input.length(); i++) {
	            char character = input.charAt(i);
	            int asciiValue = (int) character; // Cast char to int to get ASCII value
	            System.out.println(character + " : " + asciiValue);
	        }
	        
	        // Close the scanner
	        scanner.close();
	    }
	}