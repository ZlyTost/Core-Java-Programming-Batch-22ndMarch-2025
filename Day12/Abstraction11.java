package Day12;

// Example 1: Abstract Class with One Abstract Method

// Abstract class
abstract class Animal {
    abstract void sound();  // Abstract method
}

// Concrete subclass
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class Abstraction11 {
    public static void main(String[] args) {
        // Create Dog object using abstract class reference
        Animal myDog = new Dog();

        // Call the implemented method
        myDog.sound();  // Output: Dog barks
    }
}
