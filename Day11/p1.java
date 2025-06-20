package Day11;
/*
  1. super keyword examples
super is used to refer to the immediate parent class.
 */

//a) Calling parent class constructor
class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // Calls Animal() constructor
        System.out.println("Dog constructor");
    }
}

public class p1 {

	public static void main(String[] args) {
	 Animal ani1 = new Dog();

	}

}
