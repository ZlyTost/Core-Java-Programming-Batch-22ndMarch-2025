package Day5;

import java.util.Scanner;

public class p7 {
//20.Find the Sum of the First N Odd Numbers
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n * 2; i += 2) {
            sum += i;
        }
        System.out.println("Sum of first " + n + " odd numbers: " + sum);
        scanner .close();
    }
}