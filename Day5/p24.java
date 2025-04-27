package Day5;

import java.util.Scanner;

public class p24 {
//14. Count Words in a String
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        String[] words = input.split("\\s+");
	        System.out.println("Number of words: " + words.length);
	        scanner.close();
	    }
	}