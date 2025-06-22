package Day12;

// Example 2: Abstract Class with Normal Method

// Abstract class
abstract class Vehicle {
    // Abstract method (to be implemented by subclasses)
    abstract void start();

    // Concrete method
    void fuelType() {
        System.out.println("Petrol or Diesel");
    }
}

// Subclass providing implementation
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car starts with key");
    }
}

// Main class
public class Abstraction12 {
    public static void main(String[] args) {
        // Create object of Car using Vehicle reference
        Vehicle myCar = new Car();

        // Call both methods
        myCar.start();      // Output: Car starts with key
        myCar.fuelType();   // Output: Petrol or Diesel
    }
}
