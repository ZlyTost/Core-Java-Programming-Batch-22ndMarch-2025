package Day16;
//Example 2: Bank Management System 
// Superclass: Person
abstract class Person {
    protected String name;
    protected int age;
    protected final String nationality = "Indian";

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void showDetails(); // Abstract method
}

// Subclass: BankCustomer inherits Person
class BankCustomer extends Person {
    private String customerId;
    private double[] transactions;
    private double balance;
    private static int totalCustomers = 0;
    private final int MAX_TRANSACTIONS = 10;

    // Constructor
    public BankCustomer(String name, int age, String customerId) {
        super(name, age); // calling parent constructor
        this.customerId = customerId;
        this.transactions = new double[MAX_TRANSACTIONS];
        this.balance = 0.0;
        totalCustomers++;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(amount);
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction(-amount);
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Add transaction to array
    private void addTransaction(double amount) {
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == 0) {
                transactions[i] = amount;
                break;
            }
        }
    }

    // Method to display transactions
    public void showTransactions() {
        System.out.println("Transaction history for " + name + ":");
        for (double t : transactions) {
            if (t != 0) {
                System.out.println((t > 0 ? "Deposit: " : "Withdraw: ") + "₹" + Math.abs(t));
            }
        }
    }

    // Override method
    @Override
    public void showDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name + ", Age: " + age + ", Nationality: " + nationality);
        System.out.println("Current Balance: ₹" + balance);
    }

    // Static method to show total customers
    public static void showTotalCustomers() {
        System.out.println("Total customers: " + totalCustomers);
    }

    // Encapsulation getter
    public double getBalance() {
        return balance;
    }

    // Encapsulation setter
    public void setBalance(double balance) {
        if (balance >= 0)
            this.balance = balance;
    }
}

// Polymorphism example
class PremiumCustomer extends BankCustomer {
    private double cashbackRate;

    public PremiumCustomer(String name, int age, String customerId, double cashbackRate) {
        super(name, age, customerId);
        this.cashbackRate = cashbackRate;
    }

    // Overridden deposit method with cashback
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        double cashback = amount * cashbackRate;
        setBalance(getBalance() + cashback); // Using setter with "this"
        System.out.println("Cashback Received: ₹" + cashback);
    }
}

// Main class
public class p8 {
    public static void main(String[] args) {
        BankCustomer cust1 = new BankCustomer("Amit", 30, "B001");
        cust1.deposit(5000);
        cust1.withdraw(2000);
        cust1.deposit(1500);
        cust1.showTransactions();
        cust1.showDetails();

        System.out.println("\n--- Premium Customer ---");
        PremiumCustomer cust2 = new PremiumCustomer("Sneha", 28, "B002", 0.02);
        cust2.deposit(10000);
        cust2.withdraw(2500);
        cust2.showTransactions();
        cust2.showDetails();

        // Static method
        BankCustomer.showTotalCustomers();
    }
}
