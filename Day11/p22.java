package Day11;
/*
Dynamic Binding (Late Binding)

1. Method call is resolved at runtime, depending on the object type.
2. Works with method overriding.
3. Used with inheritance and polymorphism.

 */

//Example 1: Method Overriding
class Animal3 {
    void sound() {
        System.out.println("Animal3 makes sound");
    }
}

class Dog3 extends Animal3 {
    void sound() {
        System.out.println("Dog3 barks");
    }
}
public class p22 {

	public static void main(String[] args) {
		 Animal3 obj = new Dog3();  // Parent reference, child object
	        obj.sound();             // Calls Dog3's sound() at runtime
	    }
}
