package Day7;
//Program 11: Calculator Using All Basic Operators
class SimpleCalculator {
    void operations(int a, int b) {
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
    }
}

public class P19{
    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        sc.operations(20, 5);
    }
}
