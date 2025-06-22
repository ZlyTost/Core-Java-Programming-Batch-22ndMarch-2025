package Day12;
/*
 1. Banking System
Description: A simple banking system that allows 
users to create accounts, deposit, and withdraw money.
 */
//Abstract class representing a Bank Account
abstract class BankAccount {
 protected String accountNumber;
 protected double balance;

 public BankAccount(String accountNumber) {
     this.accountNumber = accountNumber;
     this.balance = 0.0;
 }

 public abstract void deposit(double amount);
 public abstract void withdraw(double amount);
 public abstract double getBalance();
}

//Class representing a Savings Account
class SavingsAccount extends BankAccount {
 public SavingsAccount(String accountNumber) {
     super(accountNumber);
 }

 @Override
 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited: " + amount);
 }

 @Override
 public void withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Insufficient balance.");
     }
 }

 @Override
 public double getBalance() {
     return balance;
 }
}

//Main class to test the Banking System
public class p1 {
 public static void main(String[] args) {
     BankAccount account = new SavingsAccount("123456");
     account.deposit(500);
     account.withdraw(200);
     System.out.println("Current Balance: " + account.getBalance());
 }
}
