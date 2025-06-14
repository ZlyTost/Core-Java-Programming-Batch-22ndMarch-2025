package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Employee Management System: 
Develop classes for Employee, Manager, and Intern. 
Use inheritance to share common attributes and methods, 
and demonstrate polymorphism with different salary calculations.
*/

// Base class representing an Employee
abstract class Employee {
    protected String name;
    protected String employeeId;
    protected double baseSalary;

    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Class representing a Manager
class Manager extends Employee {
    private double bonus;

    public Manager(String name, String employeeId, double baseSalary, double bonus) {
        super(name, employeeId, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus; // Manager's salary includes bonus
    }
}

// Class representing an Intern
class Intern extends Employee {
    private double stipend;

    public Intern(String name, String employeeId, double stipend) {
        super(name, employeeId, 0); // Interns may not have a base salary
        this.stipend = stipend;
    }

    @Override
    public double calculateSalary() {
        return stipend; // Intern's salary is just the stipend
    }
}

// Class representing a Department
class Department {
    String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added to " + departmentName + ": " + employee.name);
    }

    public void displayEmployees() {
        System.out.println("Employees in " + departmentName + ":");
        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println();
        }
    }
}

// Class representing Payroll
class Payroll {
    public void processPayroll(Department department) {
        System.out.println("Processing payroll for department: " + department.departmentName);
        department.displayEmployees();
    }
}

// Main class to run the Employee Management System
public class p12 {
    public static void main(String[] args) {
        // Create a department
        Department itDepartment = new Department("IT Department");

        // Create employees
        Manager manager = new Manager("Alice", "M001", 80000, 10000);
        Intern intern = new Intern("Bob", "I001", 1500);

        // Add employees to the department
        itDepartment.addEmployee(manager);
        itDepartment.addEmployee(intern);

        // Create Payroll and process payroll for the department
        Payroll payroll = new Payroll();
        payroll.processPayroll(itDepartment);
    }
}
