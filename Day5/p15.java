package Day5;

import java.util.Scanner;

public class p15 {
//4. Swap Two Numbers
	    public static void main(String[] args) {
	        // Create a Scanner object to read input
	        Scanner scanner = new Scanner(System.in);
	        
	        // Prompt the user for input
	        System.out.print("Enter the first number: ");
	        int a = scanner.nextInt();
	        
	        System.out.print("Enter the second number: ");
	        int b = scanner.nextInt();
	        
	        // Swap using a third variable
	        System.out.println("\nSwapping using a third variable:");
	        System.out.println("Before swapping: a = " + a + ", b = " + b);
	        int temp = a; // Use a temporary variable
	        a = b;        // Assign b to a
	        b = temp;     // Assign temp (original a) to b
	        System.out.println("After swapping: a = " + a + ", b = " + b);
	        
	        // Swap without using a third variable
	        System.out.println("\nSwapping without using a third variable:");
	        // Reset values
	        a = 5; // You can change these values for testing
	        b = 10; // You can change these values for testing
	        System.out.println("Before swapping: a = " + a + ", b = " + b);
	        
	        a = a + b; // Step 1: a now contains the sum of a and b
	        b = a - b; // Step 2: b is assigned the original value of a
	        a = a - b; // Step 3: a is assigned the original value of b
	        System.out.println("After swapping: a = " + a + ", b = " + b);
	        
	        // Close the scanner
	        scanner.close();
	    }
	}