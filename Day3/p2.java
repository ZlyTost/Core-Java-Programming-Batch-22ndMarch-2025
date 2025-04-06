package Day3;

import java.util.Scanner;

public class p2 {
    // Discount Calculator
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input original price
        System.out.print("Enter the original price of the item: ");
        double originalPrice = scanner.nextDouble();
        
        // Input discount percentage
        System.out.print("Enter the discount percentage: ");
        double discountPercentage = scanner.nextDouble();
        
        // Calculate discount amount
        double discountAmount = (discountPercentage / 100) * originalPrice;
        
        // Calculate final price
        double finalPrice = originalPrice - discountAmount;
        
        // Display results
        System.out.printf("Original Price: $%.2f%n", originalPrice);
        System.out.printf("Discount Amount: $%.2f%n", discountAmount);
        System.out.printf("Final Price after discount: $%.2f%n", finalPrice);
        
        // Close the scanner
        scanner.close();
    }
}