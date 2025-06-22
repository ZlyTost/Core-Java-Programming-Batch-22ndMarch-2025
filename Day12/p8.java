package Day12;
/*
 24. Personal Finance Manager
Description: A personal finance manager that allows users to track 
income and expenses and view their financial summary.
 */
//Interface for Finance Operations
interface FinanceOperations {
 void addIncome(double amount);
 void addExpense(double amount);
 void viewSummary();
}

//Class representing a Personal Finance Manager
class PersonalFinanceManager implements FinanceOperations {
 private double income;
 private double expenses;

 @ Override
 public void addIncome(double amount) {
     income += amount;
     System.out.println("Added income: " + amount);
 }

 @Override
 public void addExpense(double amount) {
     expenses += amount;
     System.out.println("Added expense: " + amount);
 }

 @Override
 public void viewSummary() {
     System.out.println("Total Income: " + income);
     System.out.println("Total Expenses: " + expenses);
     System.out.println("Net Balance: " + (income - expenses));
 }
}

//Main class to test the Personal Finance Manager
public class p8 {
 public static void main(String[] args) {
     PersonalFinanceManager manager = new PersonalFinanceManager();
     manager.addIncome(5000);
     manager.addExpense(1500);
     manager.viewSummary();
 }
}
