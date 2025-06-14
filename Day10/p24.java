package Day10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Online Banking System: 
Create classes for Transaction1, Account1, and User6. 
Implement methods for transferring funds and viewing Transaction1 history.
*/

// Class representing a Transaction1
class Transaction1 {
    private double amount;
    private String type; // "Credit" or "Debit"
    private Date date;

    public Transaction1(double amount, String type) {
        this.amount = amount;
        this.type = type;
        this.date = new Date(); // Current date
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction1{" +
                "amount=" + amount +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}

// Class representing a Bank Account1
class Account1 {
    private String Account1Number;
    private double balance;
    private List<Transaction1> Transaction1History;

    public Account1(String Account1Number) {
        this.Account1Number = Account1Number;
        this.balance = 0.0; // Initial balance is 0
        this.Transaction1History = new ArrayList<>();
    }

    public String getAccount1Number() {
        return Account1Number;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction1History.add(new Transaction1(amount, "Credit"));
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            Transaction1History.add(new Transaction1(amount, "Debit"));
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds for withdrawal of: " + amount);
            return false;
        }
    }

    public void viewTransaction1History() {
        System.out.println("Transaction1 History for Account1 " + Account1Number + ":");
        for (Transaction1 Transaction1 : Transaction1History) {
            System.out.println(Transaction1);
        }
    }
}

// Class representing a User6
class User6 {
    private String name;
    private Account1 Account1;

    public User6(String name, String Account1Number) {
        this.name = name;
        this.Account1 = new Account1(Account1Number);
    }

    public String getName() {
        return name;
    }

    public Account1 getAccount1() {
        return Account1;
    }

    public void depositToAccount1(double amount) {
        Account1.deposit(amount);
    }

    public void withdrawFromAccount1(double amount) {
        Account1.withdraw(amount);
    }

    public void viewAccount1Balance() {
        System.out.println("Account1 Balance for " + name + ": " + Account1.getBalance());
    }

    public void viewTransaction1History() {
        Account1.viewTransaction1History();
    }
}

// Class for managing the Bank
class Bank {
    private List<User6> User6s;

    public Bank() {
        User6s = new ArrayList<>();
    }

    public void addUser6 (User6 User6) {
        User6s.add(User6);
        System.out.println("User6  added: " + User6.getName());
    }

    public User6 getUser6 (String name) {
        for (User6  User6 : User6s) {
            if (User6.getName().equalsIgnoreCase(name)) {
                return User6;
            }
        }
        return null; // User6 not found
    }
}

// Main class to run the Online Banking System
public class p24 {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank();

        // Create User6s
        User6 User61 = new User6("Alice", "ACC123");
        User6 User62 = new User6("Bob", "ACC456");

        // Add User6s to the bank
        bank.addUser6 (User61);
        bank.addUser6 (User62);

        // Perform Transaction1s
        User61.depositToAccount1(500);
        User61.withdrawFromAccount1(200);
        User61.viewAccount1Balance();
        User61.viewTransaction1History();

        User62.depositToAccount1(1000);
        User62.withdrawFromAccount1(1500); // Should show insufficient funds
        User62.viewAccount1Balance();
        User62.viewTransaction1History();
    }
}
