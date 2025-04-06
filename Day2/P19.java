package Day2;
import java.util.Scanner;
public class P19 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter a password: ");
	        String password = scanner.nextLine();
	        
	        if (password.length() >= 8 && password.matches(".*[!@#$%^&*].*")) {
	            System.out.println("Password is valid.");
	        } else {
	            System.out.println("Password must be at least 8 characters long and contain a special character.");
	        }
	        scanner.close();
	    }
	}