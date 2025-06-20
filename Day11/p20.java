package Day11;
/*
 What is Binding in Java?
Binding refers to the linking of a method call with its definition.

Static Binding (Early Binding)
1. Method call is resolved during compilation, not at runtime. 
2. Works with private, final, static methods.
3. Uses method overloading.

 */

// Example 1: Method Overloading
class Calculator {
    void add(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    void add(double a, double b) {
        System.out.println("Sum = " + (a + b));
    }
}
public class p20 {

	public static void main(String[] args) {
		 Calculator obj = new Calculator();
	        obj.add(10, 20);       // Calls int version
	        obj.add(5.5, 6.5);     // Calls double version
	    }
}
