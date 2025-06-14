package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Online Learning Platform: 
Design classes for Course1, Student1, and Instructor. 
Implement methods for enrolling in Course1s and tracking progress.
*/

// Class representing an Instructor
class Instructor {
    private String name;
    private String expertise;

    public Instructor(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", expertise='" + expertise + '\'' +
                '}';
    }
}

// Class representing a Course1
class Course1 {
    private String title;
    private String description;
    private Instructor instructor;

    public Course1(String title, String description, Instructor instructor) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return "Course1{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}

// Class representing a Student1
class Student1 {
    private String name;
    private List<Course1> enrolledCourse1s;

    public Student1(String name) {
        this.name = name;
        this.enrolledCourse1s = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse1(Course1 Course1) {
        enrolledCourse1s.add(Course1);
        System.out.println(name + " has enrolled in " + Course1.getTitle());
    }

    public List<Course1> getEnrolledCourse1s() {
        return enrolledCourse1s;
    }

    public void showEnrolledCourse1s() {
        System.out.println(name + "'s Enrolled Course1s:");
        for (Course1 Course1 : enrolledCourse1s) {
            System.out.println(Course1);
        }
    }
}

// Class representing an Enrollment
class Enrollment {
    private Student1 Student1;
    private Course1 Course1;

    public Enrollment(Student1 Student1, Course1 Course1) {
        this.Student1 = Student1;
        this.Course1 = Course1;
    }

    public void enroll() {
        Student1.enrollInCourse1(Course1);
    }
}

// Class for tracking progress
class ProgressTracker {
    private Student1 Student1;

    public ProgressTracker(Student1 Student1) {
        this.Student1 = Student1;
    }

    public void trackProgress() {
        System.out.println("Tracking progress for " + Student1.getName());
        Student1.showEnrolledCourse1s();
    }
}

// Main class to run the Online Learning Platform
public class p6 {
    public static void main(String[] args) {
        // Create an instructor
        Instructor instructor = new Instructor("Dr. Smith", "Computer Science");

        // Create Course1s
        Course1 Course11 = new Course1("Java Programming", "Learn the basics of Java.", instructor);
        Course1 Course12 = new Course1("Data Structures", "Understand data structures and algorithms.", instructor);

        // Create a Student1
        Student1 Student1 = new Student1("Alice");

        // Enroll the Student1 in Course1s
        Enrollment enrollment1 = new Enrollment(Student1, Course11);
        enrollment1.enroll();

        Enrollment enrollment2 = new Enrollment(Student1, Course12);
        enrollment2.enroll();

        // Track the Student1's progress
        ProgressTracker progressTracker = new ProgressTracker(Student1);
        progressTracker.trackProgress();
    }
}
