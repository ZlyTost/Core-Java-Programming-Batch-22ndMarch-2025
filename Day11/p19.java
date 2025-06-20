package Day11;
// Example 2: To call current class method
class Example {
    void show() {
        System.out.println("Inside show()");
    }

    void display() {
        this.show();  // calls current class method
    }
}

public class p19 {

	public static void main(String[] args) {
		Example ex = new Example();
		ex.display();
	}
}