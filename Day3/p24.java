package Day3;
import java.util.Scanner;
public class p24 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Press Enter to start the stopwatch...");
	        scanner.nextLine();
	        
	        long startTime = System.currentTimeMillis();
	        System.out.println("Stopwatch started. Press Enter to stop...");
	        scanner.nextLine();
	        
	        long endTime = System.currentTimeMillis();
	        long elapsedTime = endTime - startTime;
	        
	        System.out.println("Elapsed time in seconds: " + (elapsedTime / 1000.0));
	        scanner.close();
	    }
	}