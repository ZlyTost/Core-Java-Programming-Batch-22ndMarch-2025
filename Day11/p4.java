package Day11;
//A program to calculate the area of different shapes using polymorphism.

//Base class
abstract class Shape {
 abstract double area(); // Abstract method
}

//Derived class for Circle
class Circle extends Shape {
 private double radius;

 // Constructor
 public Circle(double radius) {
     this.radius = radius;
 }

 // Implementing area method
 @Override
 double area() {
     return Math.PI * radius * radius;
 }
}

//Derived class for Rectangle
class Rectangle extends Shape {
 private double length;
 private double width;

 // Constructor
 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Implementing area method
 @Override
 double area() {
     return length * width;
 }
}

public class p4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
