package Day11;
//b) Accessing parent class variable
class Animal1 {
    String color = "White";
}

class Dog1 extends Animal1 {
    String color = "Black";

    void printColor() {
        System.out.println(super.color); // Outputs: White
    }
}

public class p10 {

	public static void main(String[] args) {
		Dog1 d = new Dog1();
		d.printColor();

	}

}
