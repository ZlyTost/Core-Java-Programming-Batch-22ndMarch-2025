package Day2;
import java.util.Scanner;
public class P9 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();
	        
	        System.out.println("Hello, " + name + "! Welcome!");
	        scanner.close();
	    }
	}