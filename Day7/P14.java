package Day7;
//Program 6: Adding Two Numbers Using Parameters
class Adder {
    void add(int a, int b) {
        int sum = a + b;
        System.out.println("Sum is: " + sum);
    }
}

public class P14 {
    public static void main(String[] args) {
        Adder a = new Adder();
        a.add(15, 25);
    }
}
