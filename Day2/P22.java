package Day2;
import java.util.Scanner;
public class P22 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter principal amount: ");
	        double principal = scanner.nextDouble();
	        System.out.print("Enter rate of interest: ");
	        double rate = scanner.nextDouble();
	        System.out.print("Enter time (in years): ");
	        double time = scanner.nextDouble();
	        
	        double simpleInterest = (principal * rate * time) / 100;
	        double compoundInterest = principal * Math.pow((1 + rate / 100), time) - principal;
	        
	        System.out.println("Simple Interest: " + simpleInterest);
	        System.out.println("Compound Interest: " + compoundInterest);
	        scanner.close();
	    }
	}