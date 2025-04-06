package Day3;

import java.util.Scanner;
public class p25 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        double balance = 1000.00; // Initial balance
	        
	        while (true) {
	            System.out.println("ATM Menu:");
	            System.out.println("1. Check Balance");
	            System.out.println ("2. Deposit Money");
	            System.out.println("3. Withdraw Money");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            
	            switch (choice) {
	                case 1:
	                    System.out.println("Current balance: $" + balance);
	                    break;
	                case 2:
	                    System.out.print("Enter amount to deposit: ");
	                    double deposit = scanner.nextDouble();
	                    balance += deposit;
	                    System.out.println("Deposited: $" + deposit);
	                    break;
	                case 3:
	                    System.out.print("Enter amount to withdraw: ");
	                    double withdraw = scanner.nextDouble();
	                    if (withdraw <= balance) {
	                        balance -= withdraw;
	                        System.out.println("Withdrawn: $" + withdraw);
	                    } else {
	                        System.out.println("Insufficient funds.");
	                    }
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM.");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }
	}