package Day7;
//Program 4: Method Returning a Value
class MathOperations {
    int square(int n) {
        return n * n;
    }
}

public class P12 {
    public static void main(String[] args) {
        MathOperations m = new MathOperations();
        int result = m.square(6);
        System.out.println("Square is: " + result);
    }
}
