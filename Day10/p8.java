package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Personal Finance Manager: 
Develop classes for Income, Expense1, Transaction2, User12, and FinanceManager.
Implement methods to add incomes, add Expense1s, calculate total balance, and show Transaction2 history.
*/

// Abstract base class for a Transaction2 (Income or Expense1)
abstract class Transaction2 {
    protected String description;
    protected double amount;
    protected String date; // YYYY-MM-DD

    public Transaction2(String description, double amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    // Method to get the type of Transaction2 (Income or Expense1)
    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] " + description + ": $" + amount + " on " + date;
    }
}

// Income class extending Transaction2
class Income extends Transaction2 {

    public Income(String description, double amount, String date) {
        super(description, amount, date);
    }

    @Override
    public String getType() {
        return "Income";
    }
}

// Expense1 class extending Transaction2
class Expense1 extends Transaction2 {

    public Expense1(String description, double amount, String date) {
        super(description, amount, date);
    }

    @Override
    public String getType() {
        return "Expense1";
    }
}

// User12 class to represent a User12's finance data
class User12 {
    private String User12name;
    private List<Transaction2> Transaction2s;

    public User12(String User12name) {
        this.User12name = User12name;
        this.Transaction2s = new ArrayList<>();
    }

    public String getUser12name() {
        return User12name;
    }

    public void addTransaction2(Transaction2 Transaction2) {
        Transaction2s.add(Transaction2);
        System.out.println(Transaction2.getType() + " added: " + Transaction2.getDescription() + " $" + Transaction2.getAmount());
    }

    public List<Transaction2> getTransaction2s() {
        return Transaction2s;
    }
}

// FinanceManager class to handle User12 finance operations
class FinanceManager {
    private User12 User12;

    public FinanceManager(User12 User12) {
        this.User12 = User12;
    }

    public void addIncome(String description, double amount, String date) {
        Income income = new Income(description, amount, date);
        User12.addTransaction2(income);
    }

    public void addExpense1(String description, double amount, String date) {
        Expense1 Expense1 = new Expense1(description, amount, date);
        User12.addTransaction2(Expense1);
    }

    public double calculateTotalIncome() {
        double totalIncome = 0;
        for (Transaction2 t : User12.getTransaction2s()) {
            if (t instanceof Income) {
                totalIncome += t.getAmount();
            }
        }
        return totalIncome;
    }

    public double calculateTotalExpense1s() {
        double totalExpense1 = 0;
        for (Transaction2 t : User12.getTransaction2s()) {
            if (t instanceof Expense1) {
                totalExpense1 += t.getAmount();
            }
        }
        return totalExpense1;
    }

    public double calculateBalance() {
        return calculateTotalIncome() - calculateTotalExpense1s();
    }

    public void showTransaction2History() {
        System.out.println("Transaction2 History for " + User12.getUser12name() + ":");
        for (Transaction2 t : User12.getTransaction2s()) {
            System.out.println(t);
        }
    }
}

// Main class for running the Personal Finance Manager
public class p8 {
    public static void main(String[] args) {
        // Create User12
        User12 User12 = new User12("Alice");

        // Create finance manager for this User12
        FinanceManager fm = new FinanceManager(User12);

        // Add incomes
        fm.addIncome("Salary", 3000, "2024-06-01");
        fm.addIncome("Freelance Project", 800, "2024-06-10");

        // Add Expense1s
        fm.addExpense1("Rent", 1200, "2024-06-05");
        fm.addExpense1("Groceries", 300, "2024-06-07");
        fm.addExpense1("Utilities", 150, "2024-06-08");

        // Show Transaction2s
        fm.showTransaction2History();

        // Calculate and display totals
        System.out.println("Total Income: $" + fm.calculateTotalIncome());
        System.out.println("Total Expense1s: $" + fm.calculateTotalExpense1s());
        System.out.println("Balance: $" + fm.calculateBalance());
    }
}
