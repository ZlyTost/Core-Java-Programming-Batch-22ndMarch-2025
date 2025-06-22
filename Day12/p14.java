package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 6. Student Management System

Description: A student management system that allows adding students, 
enrolling them in courses, and displaying their details.
 */
//Abstract class representing a Student
abstract class Student {
 protected String name;
 protected int studentId;

 public Student(String name, int studentId) {
     this.name = name;
     this.studentId = studentId;
 }

 public abstract void enrollCourse(String course);
 public abstract void displayDetails();
}

//Class representing a Regular Student
class RegularStudent extends Student {
 private List<String> courses = new ArrayList<>();

 public RegularStudent(String name, int studentId) {
     super(name, studentId);
 }

 @Override
 public void enrollCourse(String course) {
     courses.add(course);
     System.out.println(name + " enrolled in: " + course);
 }

 @Override
 public void displayDetails() {
     System.out.println("Student Name: " + name + ", ID: " + studentId + ", Courses: " + courses);
 }
}

//Main class to test the Student Management System
public class p14 {
 public static void main(String[] args) {
     Student student = new RegularStudent("John Doe", 101);
     student.enrollCourse("Mathematics");
     student.enrollCourse("Physics");
     student.displayDetails();
 }
}
