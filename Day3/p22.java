package Day3;
import java.util.Scanner;
public class p22 {
//Complex Expression Evaluator(Precedence & Associativity)
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Example expression: (3 + 4) * 2 - 5 / (1 + 1)
	        System.out.println("Evaluating the expression: (3 + 4) * 2 - 5 / (1 + 1)");
	        
	        // Manually calculating the expression
	        int a = 3;
	        int b = 4;
	        int c = 2;
	        int d = 5;
	        int e = 1;
	        
	        // Step 1: Calculate (3 + 4)
	        int sum = a + b; // 7
	        
	        // Step 2: Calculate (1 + 1)
	        int sum2 = e + e; // 2
	        
	        // Step 3: Calculate 5 / (1 + 1)
	        double division = (double) d / sum2; // 5 / 2 = 2.5
	        
	        // Step 4: Calculate (3 + 4) * 2
	        int multiplication = sum * c; // 7 * 2 = 14
	        
	        // Step 5: Final result: (3 + 4) * 2 - 5 / (1 + 1)
	        double result = multiplication - division; // 14 - 2.5 = 11.5
	        
	        // Display the result
	        System.out.printf("Result: %.2f%n", result);
	        
	        // Close the scanner
	        scanner.close();
	    }
	}