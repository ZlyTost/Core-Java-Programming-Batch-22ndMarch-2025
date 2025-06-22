package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 19. Fitness Class Booking System
Description: A fitness class booking system that allows 
users to book classes and view available classes.
 */
//Interface for Class Operations
interface ClassOperations {
 void bookClass(String className);
 void viewAvailableClasses();
}

//Class representing a Fitness Class Manager
class FitnessClassManager implements ClassOperations {
 private List<String> availableClasses = new ArrayList<>();
 private List<String> bookedClasses = new ArrayList<>();

 public FitnessClassManager() {
     availableClasses.add("Yoga");
     availableClasses.add("Pilates");
     availableClasses.add("Zumba");
 }

 @Override
 public void bookClass(String className) {
     if (availableClasses.contains(className)) {
         bookedClasses.add(className);
         availableClasses.remove(className);
         System.out.println("Booked class: " + className);
     } else {
         System.out.println("Class not available.");
     }
 }

 @Override
 public void viewAvailableClasses() {
     System.out.println("Available Classes: " + availableClasses);
 }
}

//Main class to test the Fitness Class Booking System
public class p3 {
 public static void main(String[] args) {
     FitnessClassManager manager = new FitnessClassManager();
     manager.viewAvailableClasses();
     manager.bookClass("Yoga");
     manager.viewAvailableClasses();
 }
}
