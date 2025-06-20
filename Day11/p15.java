package Day11;
/*
  3. final keyword examples
final is used to create constants, prevent method overriding or inheritance. 
 */

//a) Final variable
class Test {
    final int MAX = 100;

    void display() {
        // MAX = 200; // Error: Cannot assign a value to final variable
        System.out.println(MAX);
    }
}

public class p15 {

	public static void main(String[] args) {
		Test t = new Test();
		t.display();

	}

}
