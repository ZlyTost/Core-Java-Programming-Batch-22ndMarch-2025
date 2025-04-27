package Day5;
import java.util.Arrays;
import java.util.Scanner;

public class p25 {
//15. Check if a String is an Anagram

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter first string: ");
	        String str1 = scanner.nextLine();
	        System.out.print("Enter second string: ");
	        String str2 = scanner.nextLine();
	        char[] charArray1 = str1.toCharArray();
	        char[] charArray2 = str2.toCharArray();
	        Arrays.sort(charArray1);
	        Arrays.sort(charArray2);
	        if (Arrays.equals(charArray1, charArray2)) {
	            System.out.println("The strings are anagrams.");
	        } else {
	            System.out.println("The strings are not anagrams.");
	        }
	        scanner.close();
	    }
	}