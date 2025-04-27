package Day5;

import java.util.Scanner;

public class p5 {
//18.Find the Sum of the First N Even Numbers
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 2 * i;
        }
        System.out.println("Sum of first " + n + " even numbers: " + sum);
        scanner.close();
    }
}