package Day7;
//Program 24: Class with Boolean Return

class CheckPositive {
    boolean isPositive(int num) {
        return num > 0;
    }
}

public class P8 {
    public static void main(String[] args) {
        CheckPositive cp = new CheckPositive();
        boolean result = cp.isPositive(12);
        System.out.println("Is positive? " + result);
    }
}
