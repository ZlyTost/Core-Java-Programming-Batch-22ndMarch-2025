package Day12;

import java.util.HashMap;
import java.util.Map;

/*
16. Expense Tracker System
Description: An expense tracker system that allows users to log 
expenses and view total expenses.
 */
//Interface for Expense Operations
interface ExpenseOperations {
 void logExpense(String category, double amount);
 void viewTotalExpenses();
}

//Class representing an Expense Tracker
class ExpenseTracker implements ExpenseOperations {
 private Map<String, Double> expenses = new HashMap<>();

 @Override
 public void logExpense(String category, double amount) {
     expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
     System.out.println("Logged expense: " + amount + " in category: " + category);
 }

 @Override
 public void viewTotalExpenses() {
     double total = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
     System.out.println("Total Expenses: " + total);
 }
}

//Main class to test the Expense Tracker System
public class p23 {
 public static void main(String[] args) {
     ExpenseTracker tracker = new ExpenseTracker();
     tracker.logExpense("Food", 50);
     tracker.logExpense("Transport", 20);
     tracker.viewTotalExpenses();
 }
}
