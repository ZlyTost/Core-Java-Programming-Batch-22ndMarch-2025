package Day10;
/*
Banking System: 
Design classes for Account, SavingsAccount, and CurrentAccount. 
Use inheritance to implement common features and polymorphism 
for different account types.
*/

// Class representing a Customer
class Customer {
    private String name;
    private String customerId;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
}

// Base class representing a Bank Account
abstract class Account {
    protected String accountNumber;
    protected Customer customer;
    protected double balance;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0; // Initial balance is zero
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }
}

// Class representing a Savings Account
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer customer, double interestRate) {
        super(accountNumber, customer);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " to Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account.");
        }
    }

    public void applyInterest() {
        balance += balance * interestRate / 100;
        System.out.println("Interest applied. New Balance: " + balance);
    }
}

// Class representing a Current Account
class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, Customer customer, double overdraftLimit) {
        super(accountNumber, customer);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " to Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded in Current Account.");
        }
    }
}

// Class representing a Transaction
class Transaction {
    private Account account;
    private String type;
    private double amount;

    public Transaction(Account account, String type, double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    public void execute() {
        if (type.equalsIgnoreCase("deposit")) {
            account.deposit(amount);
        } else if (type.equalsIgnoreCase("withdraw")) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type.");
        }
    }
}

// Main class to run the Banking System
public class p10 {
    public static void main(String[] args) {
        // Create a customer
        Customer customer1 = new Customer("Alice", "C001");
        Customer customer2 = new Customer("Bob", "C002");

        // Create accounts
        SavingsAccount savingsAccount = new SavingsAccount("SA001", customer1, 5.0);
        CurrentAccount currentAccount = new CurrentAccount("CA001", customer2, 1000.0);

        // Perform transactions
        Transaction deposit1 = new Transaction(savingsAccount, "deposit", 500);
        deposit1.execute();

        Transaction withdraw1 = new Transaction(savingsAccount, "withdraw", 200);
        withdraw1.execute();

        Transaction deposit2 = new Transaction(currentAccount, "deposit", 1000);
        deposit2.execute();

        Transaction withdraw2 = new Transaction(currentAccount, "withdraw", 1200);
        withdraw2.execute();

        // Apply interest to savings account
        savingsAccount.applyInterest();
    }
}
