package Day2;
import java.util.Scanner;
public class P6 {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a character: ");
	        char ch = scanner.next().charAt(0);
	        System.out.println("ASCII value: " + (int) ch);
	        scanner.close();
	    }
	}