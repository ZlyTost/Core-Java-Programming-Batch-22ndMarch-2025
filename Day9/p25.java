package Day9;

import java.util.*;

// Base class representing a generic Person1 in the sports team
abstract class Person1 {
    protected String name;
    protected int age;
    protected String id;

    public Person1(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public abstract void displayInfo();
}

// Player1 class extending Person1
class Player1 extends Person1 {
    private String position;
    private int matchesPlayed;
    private int goalsScored;
    private int assists;
    private double fitnessLevel; // 0.0 to 100.0 scale

    public Player1(String name, int age, String id, String position) {
        super(name, age, id);
        this.position = position;
        this.matchesPlayed = 0;
        this.goalsScored = 0;
        this.assists = 0;
        this.fitnessLevel = 100.0;
    }

    public void recordMatchPerformance(int goals, int assists, double fitnessChange) {
        if(goals < 0 || assists < 0) throw new IllegalArgumentException("Goals and assists cannot be negative.");
        matchesPlayed++;
        goalsScored += goals;
        this.assists += assists;
        setFitnessLevel(this.fitnessLevel + fitnessChange);
    }

    public void setFitnessLevel(double fitnessLevel) {
        if(fitnessLevel < 0) this.fitnessLevel = 0;
        else if(fitnessLevel > 100) this.fitnessLevel = 100;
        else this.fitnessLevel = fitnessLevel;
    }

    public double getPerformanceRating() {
        if (matchesPlayed == 0) return 0.0;
        double rating = (goalsScored * 4 + assists * 3) / (double) matchesPlayed;
        rating *= (fitnessLevel / 100);
        return Math.min(rating, 10.0); // capped at 10
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Player1 Info ===");
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("ID         : " + id);
        System.out.println("Position   : " + position);
        System.out.println("Matches    : " + matchesPlayed);
        System.out.println("Goals      : " + goalsScored);
        System.out.println("Assists    : " + assists);
        System.out.printf("Fitness    : %.2f%%\n", fitnessLevel);
        System.out.printf("Performance Rating: %.2f / 10\n", getPerformanceRating());
        System.out.println("-------------------------");
    }
}

// Coach class extending Person1
class Coach extends Person1 {
    private List<String> trainingSchedules; // e.g., dates or sessions
    private String strategy;
    private int yearsExperience;
    private double successRate; // 0.0 to 100.0

    public Coach(String name, int age, String id, int yearsExperience) {
        super(name, age, id);
        this.trainingSchedules = new ArrayList<>();
        this.strategy = "Balanced";
        this.yearsExperience = yearsExperience;
        this.successRate = 0.0;
    }

    public void addTrainingSession(String session) {
        trainingSchedules.add(session);
    }

    public void updateStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setSuccessRate(double successRate) {
        if (successRate < 0) this.successRate = 0;
        else if (successRate > 100) this.successRate = 100;
        else this.successRate = successRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Coach Info ===");
        System.out.println("Name             : " + name);
        System.out.println("Age              : " + age);
        System.out.println("ID               : " + id);
        System.out.println("Years Experience : " + yearsExperience);
        System.out.println("Current Strategy : " + strategy);
        System.out.printf("Success Rate     : %.2f%%\n", successRate);
        System.out.println("Training Schedule:");
        if (trainingSchedules.isEmpty()) {
            System.out.println("  No scheduled sessions.");
        } else {
            trainingSchedules.forEach(session -> System.out.println("  - " + session));
        }
        System.out.println("-------------------------");
    }
}

// Manager1 class extending Person1
class Manager1 extends Person1 {
    private double salary;
    private Date contractStart;
    private Date contractEnd;
    private List<String> responsibilities;

    public Manager1(String name, int age, String id, double salary, Date contractStart, Date contractEnd) {
        super(name, age, id);
        this.salary = salary;
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
        this.responsibilities = new ArrayList<>();
    }

    public void addResponsibility(String responsibility) {
        responsibilities.add(responsibility);
    }

    public long getContractDurationDays() {
        long diff = contractEnd.getTime() - contractStart.getTime();
        return diff / (1000 * 60 * 60 * 24);
    }

    public void increaseSalary(double percentage) {
        if (percentage < 0) return;
        salary += salary * (percentage/100);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Manager1 Info ===");
        System.out.println("Name            : " + name);
        System.out.println("Age             : " + age);
        System.out.println("ID              : " + id);
        System.out.printf("Salary          : ₹%.2f\n", salary);
        System.out.println("Contract Period : " + contractStart + " to " + contractEnd + " (" + getContractDurationDays() + " days)");
        System.out.println("Responsibilities:");
        if (responsibilities.isEmpty()) {
            System.out.println("  No responsibilities assigned.");
        } else {
            responsibilities.forEach(r -> System.out.println("  - " + r));
        }
        System.out.println("-------------------------");
    }
}

public class p25 {
    public static void main(String[] args) {
        System.out.println("=== Sports Team Management System ===\n");

        Player1 Player11 = new Player1("Virat Kohli", 35, "P001", "Batsman");
        Player11.recordMatchPerformance(75, 1, -5.0);
        Player11.recordMatchPerformance(42, 0, -10.0);
        Player11.displayInfo();

        Coach coach1 = new Coach("John Smith", 50, "C101", 20);
        coach1.addTrainingSession("Monday 10am - Batting Drills");
        coach1.addTrainingSession("Wednesday 2pm - Fielding Practice");
        coach1.updateStrategy("Aggressive");
        coach1.setSuccessRate(75.5);
        coach1.displayInfo();

        Calendar cal = Calendar.getInstance();
        cal.set(2023, Calendar.JANUARY, 1);
        Date contractStart = cal.getTime();
        cal.set(2024, Calendar.DECEMBER, 31);
        Date contractEnd = cal.getTime();

        Manager1 Manager11 = new Manager1("Alice Johnson", 45, "M201", 15000000, contractStart, contractEnd);
        Manager11.addResponsibility("Player1 contracts negotiation");
        Manager11.addResponsibility("Sponsorship deals");
        Manager11.addResponsibility("Team budget management");
        Manager11.increaseSalary(10);
        Manager11.displayInfo();
    }
}
