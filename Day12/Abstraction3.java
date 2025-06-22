package Day12;

// Example 4: Abstract Class with Multiple Abstract Methods

// Abstract class
abstract class Phone {
    abstract void call();
    abstract void message();
}

// Subclass implementing all abstract methods
class SmartPhone extends Phone {
    @Override
    public void call() {
        System.out.println("Calling...");
    }

    @Override
    public void message() {
        System.out.println("Sending message...");
    }
}

// Main class
public class Abstraction3 {
    public static void main(String[] args) {
        // Creating object of SmartPhone using abstract class reference
        Phone myPhone = new SmartPhone();

        // Calling methods
        myPhone.call();     // Output: Calling...
        myPhone.message();  // Output: Sending message...
    }
}
