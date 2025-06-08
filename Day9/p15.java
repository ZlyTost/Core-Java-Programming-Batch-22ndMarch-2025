package Day9;

// Employee Management System demonstrating inheritance and complex logic

// Base class Employee
abstract class Employee {
    protected String name;
    protected int employeeId;
    protected double baseSalary;
    protected int leavesTaken;
    protected int totalLeaves;

    public Employee(String name, int employeeId, double baseSalary, int totalLeaves) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.leavesTaken = 0;
        this.totalLeaves = totalLeaves;
    }

    // Calculate total salary (with bonuses/deductions)
    public abstract double calculateSalary();

    // Take leave if available
    public boolean takeLeave(int days) {
        if (days <= (totalLeaves - leavesTaken)) {
            leavesTaken += days;
            System.out.println(name + " granted " + days + " day(s) leave.");
            return true;
        } else {
            System.out.println(name + " leave request denied. Not enough leave balance.");
            return false;
        }
    }

    // Display employee basic info
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId + ", Name: " + name);
        System.out.println("Base Salary: ₹" + baseSalary);
        System.out.println("Leaves Taken/Remaining: " + leavesTaken + "/" + (totalLeaves - leavesTaken));
    }
}

// Manager class inherits Employee
class Manager extends Employee {
    private double bonus;
    private int teamSize;
    
    public Manager(String name, int employeeId, double baseSalary, int totalLeaves, int teamSize) {
        super(name, employeeId, baseSalary, totalLeaves);
        this.teamSize = teamSize;
        this.bonus = 0;
    }

    // Calculate salary including bonuses based on team size and performance
    @Override
    public double calculateSalary() {
        // Example: Bonus = 10% of base salary + 1000 per team member
        bonus = baseSalary * 0.10 + (teamSize * 1000);
        return baseSalary + bonus;
    }

    // Set or update team size
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Manager Information ---");
        super.displayInfo();
        System.out.println("Team Size: " + teamSize);
        System.out.printf("Bonus: ₹%.2f%n", bonus);
        System.out.printf("Total Salary: ₹%.2f%n", calculateSalary());
        System.out.println("----------------------------");
    }
}

// Developer class inherits Employee
class Developer extends Employee {
    private String primaryLanguage;
    private int completedProjects;
    private double projectBonusRate;

    public Developer(String name, int employeeId, double baseSalary, int totalLeaves, String primaryLanguage) {
        super(name, employeeId, baseSalary, totalLeaves);
        this.primaryLanguage = primaryLanguage;
        this.completedProjects = 0;
        this.projectBonusRate = 2000; // ₹2000 bonus per completed project
    }

    // Add completed project count
    public void completeProject() {
        completedProjects++;
        System.out.println(name + " completed a project. Total completed projects: " + completedProjects);
    }

    // Calculate salary including project bonuses
    @Override
    public double calculateSalary() {
        return baseSalary + (completedProjects * projectBonusRate);
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Developer Information ---");
        super.displayInfo();
        System.out.println("Primary Language: " + primaryLanguage);
        System.out.println("Completed Projects: " + completedProjects);
        System.out.printf("Bonus from Projects: ₹%.2f%n", completedProjects * projectBonusRate);
        System.out.printf("Total Salary: ₹%.2f%n", calculateSalary());
        System.out.println("------------------------------");
    }
}

// Intern class inherits Employee
class Intern extends Employee {
    private int internshipPeriodMonths;
    private double stipend;

    public Intern(String name, int employeeId, double baseSalary, int totalLeaves, int internshipPeriodMonths, double stipend) {
        super(name, employeeId, baseSalary, totalLeaves);
        this.internshipPeriodMonths = internshipPeriodMonths;
        this.stipend = stipend;
    }

    // Calculate salary as stipend minus leave deductions
    @Override
    public double calculateSalary() {
        // Deduct ₹500 for each leave day taken beyond 5 days free leave
        int freeLeaves = 5;
        int deductedLeaves = Math.max(0, leavesTaken - freeLeaves);
        double deduction = deductedLeaves * 500;
        return stipend - deduction;
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Intern Information ---");
        super.displayInfo();
        System.out.println("Internship Period (months): " + internshipPeriodMonths);
        System.out.printf("Stipend: ₹%.2f%n", stipend);
        System.out.printf("Total Salary after deductions: ₹%.2f%n", calculateSalary());
        System.out.println("--------------------------");
    }
}

// Main class to test Employee Management System
public class p15 {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===\n");

        // Create Manager object
        Manager mgr = new Manager("Alice Johnson", 1001, 120000.00, 24, 5);
        mgr.displayInfo();
        mgr.takeLeave(3);
        mgr.displayInfo();

        // Create Developer object
        Developer dev = new Developer("Bob Smith", 2001, 90000.00, 18, "Java");
        dev.completeProject();
        dev.completeProject();
        dev.displayInfo();
        dev.takeLeave(10);
        dev.displayInfo();

        // Create Intern object
        Intern intern = new Intern("Charlie Lee", 3001, 0, 12, 6, 20000);
        intern.displayInfo();
        intern.takeLeave(7);  // This should cause stipend deductions
        intern.displayInfo();
    }
}


