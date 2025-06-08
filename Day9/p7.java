package Day9;
//Base class
class Animal {
 String name;

 // Constructor
 Animal(String name) {
     this.name = name;
 }

 // Method
 void makeSound() {
     System.out.println(name + " makes a sound.");
 }
}

//Derived class
class Dog extends Animal {
 
 // Constructor
 Dog(String name) {
     super(name); // Call the constructor of the base class
 }

 // Overriding method
 @Override
 void makeSound() {
     System.out.println(name + " barks.");
 }
}

//Main class
public class p7 {
 public static void main(String[] args) {
     Dog dog = new Dog("Buddy");
     dog.makeSound(); // Output: Buddy barks.
 }
}
