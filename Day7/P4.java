package Day7;
//Program 20: Factorial of a Number
class Factorial {
    void findFactorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + n + " is " + fact);
    }
}

public class P4 {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        f.findFactorial(5);
    }
}
