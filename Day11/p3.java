package Day11;
//A system to manage employee details using inheritance and polymorphism.

//Base class
class Employee {
 protected String name;
 protected int id;

 // Constructor
 public Employee(String name, int id) {
     this.name = name;
     this.id = id;
 }

 // Method to display employee details
 public void display() {
     System.out.println("Employee ID: " + id + ", Name: " + name);
 }
}

//Derived class
class Manager extends Employee {
 private String department;

 // Constructor
 public Manager(String name, int id, String department) {
     super(name, id);
     this.department = department;
 }

 // Overriding display method
 @Override
 public void display() {
     super.display();
     System.out.println("Department: " + department);
 }
}

public class p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
