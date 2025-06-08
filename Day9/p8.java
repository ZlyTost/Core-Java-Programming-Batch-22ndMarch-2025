package Day9;
//Base class
class Vehicle1 {
 String type;

 Vehicle1(String type) {
     this.type = type;
 }

 void displayType() {
     System.out.println("Vehicle1 type: " + type);
 }
}

//Intermediate class
class Car1 extends Vehicle1 {
 String model;

 Car1(String type, String model) {
     super(type);
     this.model = model;
 }

 void displayModel() {
     System.out.println("Car1 model: " + model);
 }
}

//Derived class
class SportsCar1 extends Car1 {
 int topSpeed;

 SportsCar1(String type, String model, int topSpeed) {
     super(type, model);
     this.topSpeed = topSpeed;
 }

 void displayTopSpeed() {
     System.out.println("Top speed: " + topSpeed + " km/h");
 }
}

//Main class
public class p8{
 public static void main(String[] args) {
     SportsCar1 sportsCar1 = new SportsCar1("Car1", "Ferrari", 300);
     sportsCar1.displayType(); // Output: Vehicle1 type: Car1
     sportsCar1.displayModel(); // Output: Car1 model: Ferrari
     sportsCar1.displayTopSpeed(); // Output: Top speed: 300 km/h
 }
}
