package Day2;
import java.util.Scanner;
public class P17 {
//Reverse a String
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        String reversed = new StringBuilder(input).reverse().toString();
	        
	        System.out.println("Reversed string: " + reversed);
	        scanner.close();
	    }
	}