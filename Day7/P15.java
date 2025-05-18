package Day7;
//Program 7: Subtract Two Numbers with Return Value
class Subtractor {
    int subtract(int x, int y) {
        return x - y;
    }
}

public class P15 {
    public static void main(String[] args) {
        Subtractor s = new Subtractor();
        int result = s.subtract(30, 10);
        System.out.println("Difference is: " + result);
    }
}
