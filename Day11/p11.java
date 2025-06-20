package Day11;
//c) Calling parent class method
class Animal2 {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog2 extends Animal2 {
    void eat() {
        System.out.println("Eating bread...");
    }

    void bark() {
        super.eat(); // Calls Animal2's eat method
    }
}

public class p11 {

	public static void main(String[] args) {
		Dog2 d = new Dog2();
		d.bark();
		d.eat();
	}

}
