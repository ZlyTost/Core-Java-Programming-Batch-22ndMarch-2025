package Day3;

import java.util.Scanner;

public class p21 {
    // Temperature Converter
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);
        
        if (unit == 'C') {
            // Convert Celsius to Fahrenheit
            double fahrenheit = (temperature * 9/5) + 32;
            System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.%n", temperature, fahrenheit);
        } else if (unit == 'F') {
            // Convert Fahrenheit to Celsius
            double celsius = (temperature - 32) * 5/9;
            System.out.printf("%.2f Fahrenheit is equal to %.2f Celsius.%n", temperature, celsius);
        } else {
            System.out.println("Invalid unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }
        
        // Close the scanner
        scanner.close();
    }
}