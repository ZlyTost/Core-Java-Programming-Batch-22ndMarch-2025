package Day3;
import java.util.Scanner;
public class p23 {
//Bank Interest Calculator(Precedence & Associativity)

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Input principal amount
	        System.out.print("Enter the principal amount: ");
	        double principal = scanner.nextDouble();
	        
	        // Input rate of interest
	        System.out.print("Enter the rate of interest (in %): ");
	        double rateOfInterest = scanner.nextDouble();
	        
	        // Input time period in years
	        System.out.print("Enter the time period (in years): ");
	        double time = scanner.nextDouble();
	        
	        // Calculate simple interest
	        double simpleInterest = (principal * rateOfInterest * time) / 100;
	        
	        // Calculate total amount after interest
	        double totalAmount = principal + simpleInterest;
	        
	        // Display results
	        System.out.printf("Simple Interest: $%.2f%n", simpleInterest);
	        System.out.printf("Total Amount after %.2f years: $%.2f%n", time, totalAmount);
	        
	        // Close the scanner
	        scanner.close();
	    }
	}