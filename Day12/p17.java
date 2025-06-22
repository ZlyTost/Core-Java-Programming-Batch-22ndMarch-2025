package Day12;

import java.util.HashMap;
import java.util.Map;

/*
 9. Fitness Tracker System
Description: A fitness tracker system that allows users to log workouts 
and track their progress.
 */
//Interface for Fitness Operations
interface FitnessOperations {
 void logWorkout(String workoutType, int duration);
 void displayProgress();
}

//Class representing a Fitness Tracker
class FitnessTracker implements FitnessOperations {
 private Map<String, Integer> workouts = new HashMap<>();

 @Override
 public void logWorkout(String workoutType, int duration) {
     workouts.put(workoutType, workouts.getOrDefault(workoutType, 0) + duration);
     System.out.println("Logged " + duration + " minutes of " + workoutType);
 }

 @Override
 public void displayProgress() {
     System.out.println("Workout Progress:");
     for (Map.Entry<String, Integer> entry : workouts.entrySet()) {
         System.out.println(entry.getKey() + ": " + entry.getValue() + " minutes");
     }
 }
}

//Main class to test the Fitness Tracker System
public class p17 {
 public static void main(String[] args) {
     FitnessTracker tracker = new FitnessTracker();
     tracker.logWorkout("Running", 30);
     tracker.logWorkout("Cycling", 45);
     tracker.displayProgress();
 }
}
