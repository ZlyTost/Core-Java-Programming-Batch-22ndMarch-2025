package Day4;

import java.util.Scanner;

public class p8 {
//8. Count Vowels and Consonants
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        int vowels = 0, consonants = 0;
	        for (char c : input.toCharArray()) {
	            if (Character.isLetter(c)) {
	                if ("AEIOUaeiou".indexOf(c) != -1) {
	                    vowels++;
	                } else {
	                    consonants++;
	 }
	            }
	        }
	        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
	        scanner.close();
	    }
	}