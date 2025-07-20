package Day13;
/*
 1. Marker Interface
A marker interface has no methods, just used to tag or mark classes for special 
behavior. 
 */

//Example 1: Serializable – Saving Objects to a File

import java.io.*;

class Student implements Serializable {  // Marker interface
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class p1 {
    public static void main(String[] args) throws Exception {
        Student s = new Student("Amit", 22);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
        out.writeObject(s); // Works because Student implements Serializable
        out.close();
        System.out.println("Student data saved.");
    }
}