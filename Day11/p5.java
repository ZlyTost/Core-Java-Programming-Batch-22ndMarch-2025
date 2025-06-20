package Day11;
//A simple e-commerce system to manage Product1s.

//Class representing a Product1
class Product1 {
 private String name;
 private double price;
 private static int Product1Count = 0; // Static variable

 // Constructor
 public Product1(String name, double price) {
     this.name = name;
     this.price = price;
     Product1Count++;
 }

 // Method to display Product1 details
 public void display() {
     System.out.println("Product1 Name: " + name + ", Price: " + price);
 }

 // Static method to get Product1 count
 public static int getProduct1Count() {
     return Product1Count;
 }
}

public class p5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
