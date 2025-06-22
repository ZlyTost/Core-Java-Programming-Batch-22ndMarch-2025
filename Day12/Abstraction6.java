package Day12;

// Example 7: Interface for Banking Operations

// Defining an interface
interface Bank {
    void deposit();
    void withdraw();
}

// Implementing the interface
class HDFCBank implements Bank {
    public void deposit() {
        System.out.println("Amount deposited");
    }

    public void withdraw() {
        System.out.println("Amount withdrawn");
    }
}

// Main class
public class Abstraction6 {
    public static void main(String[] args) {
        // Creating object using interface reference
        Bank myAccount = new HDFCBank();

        // Calling implemented methods
        myAccount.deposit();   // Output: Amount deposited
        myAccount.withdraw();  // Output: Amount withdrawn
    }
}
