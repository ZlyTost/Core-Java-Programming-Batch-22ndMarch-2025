package Day5;

import java.util.Scanner;

public class p17 {
//6. Count Vowels in a String
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        int count = 0;
	        for (char c : input.toCharArray()) {
	            if ("AEIOUaeiou".indexOf(c) != -1) {
	                count++;
	            }
	        }
	        System.out.println("Number of vowels: " + count);
	        scanner.close();
	    }
	}