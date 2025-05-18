package Day7;
//Program 2: Class with Multiple Methods
class Calculator {
    void add() {
        int a = 10, b = 20;
        System.out.println("Sum: " + (a + b));
    }

    void multiply() {
        int a = 5, b = 4;
        System.out.println("Product: " + (a * b));
    }
}

public class P10 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add();
        c.multiply();
    }
}
