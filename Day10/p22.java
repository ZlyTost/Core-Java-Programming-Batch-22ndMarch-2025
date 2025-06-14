package Day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Expense Tracker: 
Create classes for Expense, Category, and User4. 
Implement methods to add expenses and calculate total spending by category.
*/

// Class representing an Expense
class Expense {
    private double amount;
    private String date; // Format: YYYY-MM-DD
    private Category category;

    public Expense(double amount, String date, Category category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }
}

// Class representing a Category
class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class representing a User4
class User4 {
    private String User4name;
    private List<Expense> expenses;

    public User4(String User4name) {
        this.User4name = User4name;
        this.expenses = new ArrayList<>();
    }

    public String getUser4name() {
        return User4name;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added: " + expense.getAmount() + " in category " + expense.getCategory().getName());
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public double calculateTotalSpendingByCategory(String categoryName) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory().getName().equalsIgnoreCase(categoryName)) {
                total += expense.getAmount();
            }
        }
        return total;
    }
}

// Class representing the Expense Tracker
class ExpenseTracker {
    private List<User4> User4s;

    public ExpenseTracker() {
        User4s = new ArrayList<>();
    }

    public void addUser4 (User4 User4) {
        User4s.add(User4);
        System.out.println("User4  added: " + User4.getUser4name());
    }

    public User4 getUser4 (String User4name) {
        for (User4  User4 : User4s) {
            if (User4.getUser4name().equalsIgnoreCase(User4name)) {
                return User4;
            }
        }
        return null; // User4 not found
    }
}

// Class for generating reports (demonstrates polymorphism)
class Report {
    public static void generateCategoryReport(User4 User4) {
        Map<String, Double> categoryTotals = new HashMap<>();
        for (Expense expense : User4.getExpenses()) {
            String categoryName = expense.getCategory().getName();
            categoryTotals.put(categoryName, categoryTotals.getOrDefault(categoryName, 0.0) + expense.getAmount());
        }

        System.out.println("Expense Report for " + User4.getUser4name() + ":");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Total Spending: " + entry.getValue());
        }
    }
}

// Main class to run the Expense Tracker
public class p22 {
    public static void main(String[] args) {
        // Create an expense tracker
        ExpenseTracker expenseTracker = new ExpenseTracker();

        // Create User4s
        User4 User41 = new User4("Alice");
        User4 User42 = new User4("Bob");

        // Add User4s to the expense tracker
        expenseTracker.addUser4 (User41);
        expenseTracker.addUser4 (User42);

        // Create categories
        Category food = new Category("Food");
        Category transport = new Category("Transport");
        Category entertainment = new Category("Entertainment");

        // Add expenses for User4s
        User41.addExpense(new Expense(50.0, "2023-10-01", food));
        User41.addExpense(new Expense(20.0, "2023-10-02", transport));
        User41.addExpense(new Expense(30.0, "2023-10-03", entertainment));

        User42.addExpense(new Expense(15.0, "2023-10-01", food));
        User42.addExpense(new Expense(25.0, "2023-10-02", transport));

        // Generate reports
        Report.generateCategoryReport(User41);
        Report.generateCategoryReport(User42);
    }
}
