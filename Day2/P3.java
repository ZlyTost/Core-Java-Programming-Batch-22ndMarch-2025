package Day2;
import java.util.Scanner;
public class P3 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter a sentence: ");
	        String sentence = scanner.nextLine();
	        String[] words = sentence.trim().split("\\s+");
	        
	        System.out.println("Number of words: " + words.length);
	        scanner.close();
	    }
	}