package Day12;

// Example 3: Interface Example (100% Abstraction)

// Interface with abstract method
interface Shape {
    void draw();  // Interface methods are abstract by default
}

// Implementation of the interface
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Another implementation (for more clarity)
class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Main class
public class Abstraction2 {
    public static void main(String[] args) {
        // Creating objects using interface reference

        Shape s1 = new Circle();
        s1.draw();  // Output: Drawing Circle

        Shape s2 = new Square();
        s2.draw();  // Output: Drawing Square
    }
}
