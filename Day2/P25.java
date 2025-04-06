package Day2;
import java.util.Random;
import java.util.Scanner;
public class P25 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        
	        System.out.print("Enter your choice (rock, paper, scissors): ");
	        String userChoice = scanner.nextLine().toLowerCase();
	        String[] choices = {"rock", "paper", "scissors"};
	        String computerChoice = choices[random.nextInt(3)];
	        
	        System.out.println("Computer chose: " + computerChoice);
	        
	if (userChoice.equals(computerChoice)) {
	            System.out.println("It's a tie!");
	        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
	                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
	                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
	            System.out.println("You win!");
	        } else {
	            System.out.println("You lose!");
	        }
	        scanner.close();
	    }
	}