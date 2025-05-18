package Day7;
//Program 23: Swap Two Numbers (Without 3rd Variable)
class Swapper {
    void swap(int a, int b) {
        System.out.println("Before Swap: a=" + a + ", b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After Swap: a=" + a + ", b=" + b);
    }
}

public class P7 {
    public static void main(String[] args) {
        Swapper s = new Swapper();
        s.swap(10, 20);
    }
}
