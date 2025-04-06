package Day3;

import java.util.Scanner;

public class p18 {
    // Distance Converter
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter distance: ");
        double distance = scanner.nextDouble();
        
        System.out.print("Enter unit (km for kilometers, mi for miles): ");
        String unit = scanner.next().toLowerCase();
        
        if (unit.equals("km")) {
            // Convert kilometers to miles
            double miles = distance * 0.621371;
            System.out.printf("%.2f kilometers is equal to %.2f miles.%n", distance, miles);
        } else if (unit.equals("mi")) {
            // Convert miles to kilometers
            double kilometers = distance / 0.621371;
            System.out.printf("%.2f miles is equal to %.2f kilometers.%n", distance, kilometers);
        } else {
            System.out.println("Invalid unit. Please enter 'km' for kilometers or 'mi' for miles.");
        }
        
        scanner.close();
    }
}