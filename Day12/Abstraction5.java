package Day12;

// Example 6: Abstract Class as Blueprint

// Abstract class representing a generic employee
abstract class Employee {
    abstract void work();  // Abstract method to be implemented by subclasses
}

// Concrete class providing specific implementation
class Developer extends Employee {
    @Override
    public void work() {
        System.out.println("Writes code");
    }
}

// Main class
public class Abstraction5 {
    public static void main(String[] args) {
        // Creating Developer object using abstract class reference
        Employee emp = new Developer();

        // Calling the overridden method
        emp.work();  // Output: Writes code
    }
}
