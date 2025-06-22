package Day12;

// Example 5: Partial Abstraction (Abstract class with both methods)

// Abstract class with both abstract and concrete methods
abstract class Appliance {
    void plugIn() {
        System.out.println("Plugged in");
    }

    abstract void operate();  // Abstract method
}

// Concrete class extending the abstract class
class Fan extends Appliance {
    @Override
    public void operate() {
        System.out.println("Fan is spinning");
    }
}

// Main class
public class Abstraction4 {
    public static void main(String[] args) {
        // Create object using abstract class reference
        Appliance myAppliance = new Fan();

        // Call both methods
        myAppliance.plugIn();   // Concrete method from abstract class
        myAppliance.operate();  // Implemented in subclass
    }
}
