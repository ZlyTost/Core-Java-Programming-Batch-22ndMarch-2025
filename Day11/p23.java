package Day11;
// Example 2: Runtime Polymorphism
class Vehicle1 {
    void run() {
        System.out.println("Vehicle1 is running");
    }
}

class Car extends Vehicle1 {
    void run() {
        System.out.println("Car is running");
    }
}

public class p23{
    public static void main(String[] args) {
        Vehicle1 v = new Car();   // Reference of superclass
        v.run();                 // Executes Car’s run() method
    }
}
