package Day2;
import java.util.Scanner;
public class P7 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int num = scanner.nextInt();
	        boolean isPrime = true;
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                isPrime = false;
	                break;
	            }
	        }
	        System.out.println(num + (isPrime ? " is a prime number." : " is not a prime number."));
	        scanner.close();
	    }
	}