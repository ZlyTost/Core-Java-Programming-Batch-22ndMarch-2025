package Day2;
import java.util.Scanner;
public class P5 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        System.out.print("Enter a character to count: ");
	        char character = scanner.next().charAt(0);
	        
	        int count = 0;
	        for (char c : input.toCharArray()) {
	            if (c == character) {
	                count++;
	            }
	        }
	        
	        System.out.println("Character '" + character + "' appears " + count + " times.");
	        scanner.close();
	    }
	}