package Day7;
// Program 25: Counter
public class P9 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        // Print current count
        System.out.println("Current Count: " + counter.getCount());
    }
}

class Counter {
    private int count;

    // Method to increment count
    public void increment() {
        count++;
    }

    // Method to get current count
    public int getCount() {
        return count;
    }
}
