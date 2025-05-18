package Day7;
//Program 18: Even or Odd Number
class NumberCheck {
    void isEven(int n) {
        if (n % 2 == 0)
            System.out.println(n + " is even");
        else
            System.out.println(n + " is odd");
    }
}

public class P25 {
    public static void main(String[] args) {
        NumberCheck nc = new NumberCheck();
        nc.isEven(9);
    }
}
