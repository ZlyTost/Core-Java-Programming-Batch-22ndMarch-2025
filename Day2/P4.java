package Day2;
import java.util.Scanner;
public class P4 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter principal amount: ");
	        int principal = scanner.nextInt();
	        System.out.print("Enter rate of interest: ");
	        int rate = scanner.nextInt();
	        System.out.print("Enter time (in years): ");
	        int time = scanner.nextInt();
	        
	        double interest = (double) (principal * rate * time) / 100;
	        System.out.println("Simple Interest: " + interest);
	        scanner.close();
	    }
	}