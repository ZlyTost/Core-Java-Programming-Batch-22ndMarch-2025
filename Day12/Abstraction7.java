package Day12;

// Example 8: Abstract Class with Constructor

// Abstract class with constructor
abstract class Machine {
    Machine() {
        System.out.println("Machine is created");
    }

    abstract void run();  // Abstract method
}

// Concrete class extending the abstract class
class WashingMachine extends Machine {
    @Override
    public void run() {
        System.out.println("Washing clothes...");
    }
}

// Main class
public class Abstraction7 {
    public static void main(String[] args) {
        // Creating object of WashingMachine
        Machine myMachine = new WashingMachine();

        // Calling run method
        myMachine.run();
    }
}
