package Day7;
// Program 21: Reversing a Number
class Reverse {
    void reverseNumber(int num) {
        int rev = 0;
        while (num != 0) {
            int d = num % 10;
            rev = rev * 10 + d;
            num /= 10;
        }
        System.out.println("Reversed number: " + rev);
    }
}

public class P5 {
    public static void main(String[] args) {
        Reverse r = new Reverse();
        r.reverseNumber(1234);
    }
}
