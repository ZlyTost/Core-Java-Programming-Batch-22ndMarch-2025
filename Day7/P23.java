package Day7;
//Program 16: Comparing Two Numbers
class Compare {
    void checkMax(int a, int b) {
        if (a > b)
            System.out.println(a + " is greater");
        else
            System.out.println(b + " is greater");
    }
}

public class P23 {
    public static void main(String[] args) {
        Compare c = new Compare();
        c.checkMax(50, 40);
    }
}
