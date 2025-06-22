package Day12;
/*
 5. Vehicle1 Management System
Description: A Vehicle1 management system that allows adding Vehicle1s 
and displaying their details.
 */
//Abstract class representing a Vehicle1
abstract class Vehicle1 {
 protected String model;
 protected String licensePlate;

 public Vehicle1(String model, String licensePlate) {
     this.model = model;
     this.licensePlate = licensePlate;
 }

 public abstract void displayDetails();
}

//Class representing a Car1
class Car1 extends Vehicle1 {
 public Car1(String model, String licensePlate) {
     super(model, licensePlate);
 }

 @Override
 public void displayDetails() {
     System.out.println("Car1 Model: " + model + ", License Plate: " + licensePlate);
 }
}

//Class representing a Bike
class Bike extends Vehicle1 {
 public Bike(String model, String licensePlate) {
     super(model, licensePlate);
 }

 @Override
 public void displayDetails() {
     System.out.println("Bike Model: " + model + ", License Plate: " + licensePlate);
 }
}

//Main class to test the Vehicle1 Management System
public class p13 {
 public static void main(String[] args) {
     Vehicle1 Car1 = new Car1("Toyota", "ABC123");
     Vehicle1 bike = new Bike("Yamaha", "XYZ789");
     
     Car1.displayDetails();
     bike.displayDetails();
 }
}
