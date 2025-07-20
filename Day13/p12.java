package Day13;
/*
 2. Copy Constructor
Copying values of one object to another.
 */

//Example 1: Copying Bank Account
class BankAccount {
    String holder;
    double balance;
    
    BankAccount(String h, double b) {
        holder = h;
        balance = b;
    }

    // Copy constructor
    BankAccount(BankAccount acc) {
        holder = acc.holder;
        balance = acc.balance;
    }
}

public class p12 {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Rahul", 5000);
        BankAccount a2 = new BankAccount(a1);
        System.out.println(a2.holder + ": " + a2.balance);
    }
}
