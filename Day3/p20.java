package Day3;

import java.util.Scanner;

public class p20 {
    // Eligibility Checker
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        // Check eligibility
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }
        
        // Close the scanner
        scanner.close();
    }
}