package Day11;
//Example 2: Static Method Call
class Greeting {
    static void sayHello() {
        System.out.println("Hello from static method!");
    }
}

public class p21 {

	public static void main(String[] args) {
		 Greeting.sayHello(); // Static method call
	}

}
