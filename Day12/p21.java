package Day12;

import java.util.HashMap;
import java.util.Map;

/*
 14. Online Banking System
Description: An online banking system that allows users to transfer 
money between accounts and check balances.
 */
//Interface for Banking Operations
interface BankingOperations {
 void transferMoney(String fromAccount, String toAccount, double amount);
 void checkBalance(String account);
}

//Class representing an Online Bank
class OnlineBank implements BankingOperations {
 private Map<String, Double> accounts = new HashMap<>();

 public OnlineBank() {
     accounts.put("123456", 1000.0);
     accounts.put("654321", 500.0);
 }

 @Override
 public void transferMoney(String fromAccount, String toAccount, double amount) {
     if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount) && accounts.get(fromAccount) >= amount) {
         accounts.put(fromAccount, accounts.get(fromAccount) - amount);
         accounts.put(toAccount, accounts.get(toAccount) + amount);
         System.out.println("Transferred " + amount + " from " + fromAccount + " to " + toAccount);
     } else {
         System.out.println("Transfer failed. Check account details or balance.");
     }
 }

 @Override
 public void checkBalance(String account) {
     Double balance = accounts.get(account);
     if (balance != null) {
         System.out.println("Balance for account " + account + ": " + balance);
     } else {
         System.out.println("Account not found.");
     }
 }
}

//Main class to test the Online Banking System
public class p21 {
 public static void main(String[] args) {
     OnlineBank bank = new OnlineBank();
     bank.checkBalance("123456");
     bank.transferMoney("123456", "654321", 200);
     bank.checkBalance("123456");
     bank.checkBalance("654321");
 }
}
