package Day12;

public class Abstraction10 implements I1 {

    // --- I1 methods ---
    public void I1m1() { System.out.println("I1 Method 1"); }
    public void I1m2() { System.out.println("I1 Method 2"); }
    public void I1m3() { System.out.println("I1 Method 3"); }
    public void I1m4() { System.out.println("I1 Method 4"); }
    public void I1m5() { System.out.println("I1 Method 5"); }

    // --- I2 methods ---
    public void I2m1() { System.out.println("I2 Method 1"); }
    public void I2m2() { System.out.println("I2 Method 2"); }
    public void I2m3() { System.out.println("I2 Method 3"); }
    public void I2m4() { System.out.println("I2 Method 4"); }
    public void I2m5() { System.out.println("I2 Method 5"); }

    // --- I3 methods ---
    public void I3m1() { System.out.println("I3 Method 1"); }
    public void I3m2() { System.out.println("I3 Method 2"); }
    public void I3m3() { System.out.println("I3 Method 3"); }
    public void I3m4() { System.out.println("I3 Method 4"); }
    public void I3m5() { System.out.println("I3 Method 5"); }

    // --- I4 methods ---
    public void I4m1() { System.out.println("I4 Method 1"); }
    public void I4m2() { System.out.println("I4 Method 2"); }
    public void I4m3() { System.out.println("I4 Method 3"); }
    public void I4m4() { System.out.println("I4 Method 4"); }
    public void I4m5() { System.out.println("I4 Method 5"); }

    // --- I5 methods ---
    public void I5m1() { System.out.println("I5 Method 1"); }
    public void I5m2() { System.out.println("I5 Method 2"); }
    public void I5m3() { System.out.println("I5 Method 3"); }
    public void I5m4() { System.out.println("I5 Method 4"); }
    public void I5m5() { System.out.println("I5 Method 5"); }

    // --- Main Method ---
    public static void main(String[] args) {
        Abstraction10 obj = new Abstraction10();

        // Calling some methods for demo
        obj.I1m1();
        obj.I2m2();
        obj.I3m3();
        obj.I4m4();
        obj.I5m5();
    }
}
