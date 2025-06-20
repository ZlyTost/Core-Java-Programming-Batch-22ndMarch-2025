package Day11;
//A system to manage different types of Vehicle2s using inheritance.

//Base class
class Vehicle2 {
 protected String brand;

 // Constructor
 public Vehicle2(String brand) {
     this.brand = brand;
 }

 // Method to display Vehicle2 details
 public void display() {
     System.out.println("Brand: " + brand);
 }
}

//Derived class for Car2
class Car2 extends Vehicle2 {
 private int doors;

 // Constructor
 public Car2(String brand, int doors) {
     super(brand);
     this.doors = doors;
 }

 // Overriding display method
 @Override
 public void display() {
     super.display();
     System.out.println("Doors: " + doors);
 }
}

public class p6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
