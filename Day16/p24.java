package Day16;

//------------------------------- Example 2: Encapsulation with Validation -------------------------------

/*
 * This class demonstrates encapsulation with validation.
 * The balance field is private and cannot be accessed directly from outside the class.
 * Deposit and withdrawal operations are only allowed under valid conditions.
 */
class BankAccount {
    // Private field to store account balance
    private double balance;

    // Public method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        // Only allow deposit if the amount is greater than 0
        if (amount > 0) {
            balance += amount;  // Add amount to the balance
        } else {
            System.out.println("Deposit amount must be positive."); 
            // Error message for invalid input
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        // Allow withdrawal only if the amount is positive and less than or equal to current balance
        if (amount > 0 && amount <= balance) {
            balance -= amount;  // Subtract amount from the balance
        } else {
            System.out.println("Invalid withdrawal amount.");  
            // Error for insufficient funds or invalid amount
        }
    }
}

// Main class to test the BankAccount class
public class p24 {
    public static void main(String[] args) {
        // Create a new bank account object
        BankAccount account = new BankAccount();

        // Deposit money into the account
        account.deposit(500);  // Valid deposit
        System.out.println("Current Balance: " + account.getBalance());  // Output: 500.0

        // Withdraw money from the account
        account.withdraw(200);  // Valid withdrawal
        System.out.println("Current Balance: " + account.getBalance());  // Output: 300.0
    }
}
