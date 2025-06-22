package Day12;

// Example 9: Interface with Multiple Implementations

// Interface
interface Payment {
    void pay();  // abstract method
}

// Implementation 1
class UPI implements Payment {
    public void pay() {
        System.out.println("💰 Payment via UPI");
    }
}

// Implementation 2
class CreditCard implements Payment {
    public void pay() {
        System.out.println("💳 Payment via Credit Card");
    }
}

// Main class
public class Abstraction8 {
    public static void main(String[] args) {

        // Using interface reference for UPI payment
        Payment p1 = new UPI();
        p1.pay(); // Output: Payment via UPI

        // Using interface reference for Credit Card payment
        Payment p2 = new CreditCard();
        p2.pay(); // Output: Payment via Credit Card

        // Anonymous way (additional understanding)
        Payment p3 = new Payment() {
            public void pay() {
                System.out.println("💵 Payment via Cash");
            }
        };
        p3.pay(); // Output: Payment via Cash
    }
}
