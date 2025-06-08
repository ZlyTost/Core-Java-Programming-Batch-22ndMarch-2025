package Day9;
//Base class
class Person2 {
 String name;

 Person2(String name) {
     this.name = name;
 }
}

//Derived class
class Employee1 extends Person2 {
 int Employee1Id;

 Employee1(String name, int Employee1Id) {
     super(name); // Call the constructor of the base class
     this.Employee1Id = Employee1Id;
 }

 void displayInfo() {
     System.out.println("Name: " + name + ", Employee1 ID: " + Employee1Id);
 }
}

//Main class
public class p9{
 public static void main(String[] args) {
     Employee1 emp = new Employee1("Alice", 101);
     emp.displayInfo(); // Output: Name: Alice, Employee1 ID: 101
 }
}
