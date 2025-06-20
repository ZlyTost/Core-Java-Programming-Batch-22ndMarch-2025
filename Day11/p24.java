package Day11;
//A simple banking system that allows creating accounts, depositing, and withdrawing money.

//Class representing a bank account
class BankAccount {
 private String accountNumber;
 private String accountHolder;
 private double balance;

 // Constructor
 public BankAccount(String accountNumber, String accountHolder) {
     this.accountNumber = accountNumber;
     this.accountHolder = accountHolder;
     this.balance = 0.0; // Initial balance
 }

 // Method to deposit money
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 // Method to withdraw money
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Invalid withdrawal amount.");
     }
 }

 // Method to check balance
 public double getBalance() {
     return balance;
 }
}

public class p24{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

