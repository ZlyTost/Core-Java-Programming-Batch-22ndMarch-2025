package Day9;

import java.util.*;

// Base Person class containing shared attributes
abstract class Person {
    protected String name;
    protected int age;
    protected String id;

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public abstract void displayInfo();
}

// Student1 class with grades, attendance and calculation logic
class Student1 extends Person {
    private Map<String, List<Integer>> subjectGrades; // Subject -> list of grades
    private int totalClasses;
    private int attendedClasses;

    public Student1(String name, int age, String id) {
        super(name, age, id);
        this.subjectGrades = new HashMap<>();
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    // Record attendance for a class (true if present)
    public void recordAttendance(boolean present) {
        totalClasses++;
        if (present) attendedClasses++;
    }

    // Add grade for subject
    public void addGrade(String subject, int grade) {
        subjectGrades.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade);
    }

    // Calculate average grade for a subject
    public double getAverageGrade(String subject) {
        List<Integer> grades = subjectGrades.get(subject);
        if (grades == null || grades.isEmpty())
            return 0.0;
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    // Calculate overall average grade across all subjects
    public double getOverallAverageGrade() {
        return subjectGrades.values().stream()
            .flatMap(List::stream)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
    }

    // Calculate attendance percentage
    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0.0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Student1 Info ===");
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("ID      : " + id);
        System.out.printf("Attendance: %.2f%% (%d/%d classes attended)%n", getAttendancePercentage(), attendedClasses, totalClasses);
        System.out.println("Grades:");
        for (String subject : subjectGrades.keySet()) {
            System.out.printf("  %s: Average %.2f, Grades %s%n", subject, getAverageGrade(subject), subjectGrades.get(subject));
        }
        System.out.printf("Overall Average Grade: %.2f%n", getOverallAverageGrade());
        System.out.println("-----------------------------");
    }
}

// Teacher class with subject expertise, schedule, and performance rating
class Teacher extends Person {
    private List<String> subjectsTaught;
    private Map<String, List<String>> weeklySchedule; // Day -> list of subjects/activities
    private double performanceRating;  // 0 to 5 scale

    public Teacher(String name, int age, String id) {
        super(name, age, id);
        this.subjectsTaught = new ArrayList<>();
        this.weeklySchedule = new LinkedHashMap<>();
        this.performanceRating = 0.0;
        initDefaultSchedule();
    }

    private void initDefaultSchedule() {
        // Initialize weekly schedule with empty lists for each day Monday to Friday
        List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        for (String day : days) {
            weeklySchedule.put(day, new ArrayList<>());
        }
    }

    public void addSubject(String subject) {
        if (!subjectsTaught.contains(subject))
            subjectsTaught.add(subject);
    }

    // Assign activity or class to a day
    public void assignSchedule(String day, String activity) {
        List<String> dayActivities = weeklySchedule.get(day);
        if (dayActivities != null) {
            dayActivities.add(activity);
        }
    }

    public void setPerformanceRating(double rating) {
        if (rating < 0) rating = 0;
        if (rating > 5) rating = 5;
        performanceRating = rating;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Teacher Info ===");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("ID     : " + id);
        System.out.println("Subjects Taught: " + String.join(", ", subjectsTaught));
        System.out.println("Weekly Schedule:");
        for (var entry : weeklySchedule.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
        System.out.printf("Performance Rating: %.2f / 5%n", performanceRating);
        System.out.println("-----------------------------");
    }
}

// Staff class with role, shifts, and attendance tracking
class Staff extends Person {
    private String role;
    private List<String> shifts;  // e.g., Morning, Evening
    private int workingDays;
    private int absentDays;

    public Staff(String name, int age, String id, String role) {
        super(name, age, id);
        this.role = role;
        this.shifts = new ArrayList<>();
        this.workingDays = 0;
        this.absentDays = 0;
    }

    public void addShift(String shift) {
        if (!shifts.contains(shift))
            shifts.add(shift);
    }

    public void recordAttendance(boolean present) {
        if (present) workingDays++;
        else absentDays++;
    }

    public double getAttendanceRate() {
        int totalDays = workingDays + absentDays;
        if (totalDays == 0) return 0.0;
        return (workingDays * 100.0) / totalDays;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Staff Info ===");
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("ID    : " + id);
        System.out.println("Role  : " + role);
        System.out.println("Shifts: " + String.join(", ", shifts));
        System.out.printf("Attendance rate: %.2f%% (%d days present, %d days absent)%n", getAttendanceRate(), workingDays, absentDays);
        System.out.println("-----------------------------");
    }
}

public class p18 {
    public static void main(String[] args) {
        System.out.println("=== School Management System ===\n");

        // Student1 example
        Student1 Student11 = new Student1("Rahul Sharma", 16, "S101");
        Student11.recordAttendance(true);
        Student11.recordAttendance(false);
        Student11.recordAttendance(true);
        Student11.addGrade("Math", 85);
        Student11.addGrade("Math", 92);
        Student11.addGrade("Science", 78);
        Student11.addGrade("Science", 82);
        Student11.displayInfo();

        // Teacher example
        Teacher teacher1 = new Teacher("Anita Joshi", 40, "T201");
        teacher1.addSubject("Math");
        teacher1.addSubject("Science");
        teacher1.assignSchedule("Monday", "Math - Class 10");
        teacher1.assignSchedule("Wednesday", "Science - Class 10");
        teacher1.assignSchedule("Friday", "Math - Class 9");
        teacher1.setPerformanceRating(4.5);
        teacher1.displayInfo();

        // Staff example
        Staff staff1 = new Staff("Sunil Patil", 35, "ST301", "Lab Assistant");
        staff1.addShift("Morning");
        staff1.addShift("Afternoon");
        staff1.recordAttendance(true);
        staff1.recordAttendance(true);
        staff1.recordAttendance(false);
        staff1.displayInfo();
    }
}
