package Day12;
/*
 3. Employee1 Management System
Description: An Employee1 management system that allows adding Employee1s 
and calculating their salaries.
 */
//Abstract class representing an Employee1
abstract class Employee1 {
 protected String name;
 protected double baseSalary;

 public Employee1(String name, double baseSalary) {
     this.name = name;
     this.baseSalary = baseSalary;
 }

 public abstract double calculateSalary();
}

//Class representing a Full-Time Employee1
class FullTimeEmployee1 extends Employee1 {
 public FullTimeEmployee1(String name, double baseSalary) {
     super(name, baseSalary);
 }

 @Override
 public double calculateSalary() {
     return baseSalary; // Full-time salary
 }
}

//Class representing a Part-Time Employee1
class PartTimeEmployee1 extends Employee1 {
 private int hoursWorked;

 public PartTimeEmployee1(String name, double baseSalary, int hoursWorked) {
     super(name, baseSalary);
     this.hoursWorked = hoursWorked;
 }

 @Override
 public double calculateSalary() {
     return baseSalary * hoursWorked; // Part-time salary based on hours worked
 }
}

//Main class to test the Employee1 Management System
public class p11 {
 public static void main(String[] args) {
     Employee1 emp1 = new FullTimeEmployee1("Alice", 5000);
     Employee1 emp2 = new PartTimeEmployee1("Bob", 20, 100);
     
     System.out.println(emp1.name + "'s Salary: " + emp1.calculateSalary());
     System.out.println(emp2.name + "'s Salary: " + emp2.calculateSalary());
 }
}
