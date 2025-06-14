package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Student Management System: 
Create a Student class with attributes like name, roll number, and grades. 
Implement methods for calculating average grades and displaying student details.
*/

// Class representing a Course
class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
}

// Class representing a Grade
class Grade {
    private Course course;
    private double score;

    public Grade(Course course, double score) {
        this.course = course;
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public double getScore() {
        return score;
    }
}

// Class representing a Student
class Student {
    String name;
    private String rollNumber;
    private List<Grade> grades;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        double total = 0;
        for (Grade grade : grades) {
            total += grade.getScore();
        }
        return grades.size() > 0 ? total / grades.size() : 0;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grades:");
        for (Grade grade : grades) {
            System.out.println(" - " + grade.getCourse().getCourseName() + ": " + grade.getScore());
        }
        System.out.println("Average Grade: " + calculateAverage());
    }
}

// Class representing the Student Management System
class StudentManagementSystem {
    List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.name);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            student.displayDetails();
            System.out.println();
        }
    }
}

// Class representing a Scholarship
class Scholarship {
    private double minimumAverage;

    public Scholarship(double minimumAverage) {
        this.minimumAverage = minimumAverage;
    }

    public boolean isEligible(Student student) {
        return student.calculateAverage() >= minimumAverage;
    }
}

// Main class to run the Student Management System
public class p11 {
    public static void main(String[] args) {
        // Create courses
        Course math = new Course("Mathematics", "MATH101");
        Course science = new Course("Science", "SCI101");
        Course history = new Course("History", "HIST101");

        // Create students
        Student student1 = new Student("Alice", "S001");
        student1.addGrade(new Grade(math, 85));
        student1.addGrade(new Grade(science, 90));
        student1.addGrade(new Grade(history, 78));

        Student student2 = new Student("Bob", "S002");
        student2.addGrade(new Grade(math, 70));
        student2.addGrade(new Grade(science, 60));
        student2.addGrade(new Grade(history, 65));

        // Create Student Management System
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addStudent(student1);
        sms.addStudent(student2);

        // Display all students
        sms.displayAllStudents();

        // Create a scholarship and check eligibility
        Scholarship scholarship = new Scholarship(75);
        System.out.println("Scholarship Eligibility:");
        for (Student student : sms.students) {
            if (scholarship.isEligible(student)) {
                System.out.println(student.name + " is eligible for the scholarship.");
            } else {
                System.out.println(student.name + " is not eligible for the scholarship.");
            }
        }
    }
}
