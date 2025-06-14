package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Fitness Tracker: 
Create classes for User3, Activity, and Workout. 
Implement methods to log activities and calculate calories burned.
*/

// Class representing an Activity
class Activity {
    private String name;
    private double caloriesPerMinute; // Calories burned per minute for this activity

    public Activity(String name, double caloriesPerMinute) {
        this.name = name;
        this.caloriesPerMinute = caloriesPerMinute;
    }

    public String getName() {
        return name;
    }

    public double getCaloriesPerMinute() {
        return caloriesPerMinute;
    }
}

// Class representing a Workout
class Workout {
    private List<Activity> activities;
    private String date;

    public Workout(String date) {
        this.activities = new ArrayList<>();
        this.date = date;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public String getDate() {
        return date;
    }

    public double calculateTotalCaloriesBurned() {
        double totalCalories = 0;
        for (Activity activity : activities) {
            // Assuming each activity is logged for 30 minutes for simplicity
            totalCalories += activity.getCaloriesPerMinute() * 30;
        }
        return totalCalories;
    }
}

// Class representing a User3
class User3 {
    private String User3name;
    private List<Workout> workouts;

    public User3(String User3name) {
        this.User3name = User3name;
        this.workouts = new ArrayList<>();
    }

    public String getUser3name() {
        return User3name;
    }

    public void logWorkout(Workout workout) {
        workouts.add(workout);
        System.out.println("Workout logged for " + User3name + " on " + workout.getDate());
    }

    public void displayWorkouts() {
        System.out.println(User3name + "'s Workouts:");
        for (Workout workout : workouts) {
            System.out.println("Date: " + workout.getDate() + ", Total Calories Burned: " + workout.calculateTotalCaloriesBurned());
        }
    }
}

// Class for Calorie Calculator (demonstrates polymorphism)
class CalorieCalculator {
    public static double calculateCalories(Activity activity, int minutes) {
        return activity.getCaloriesPerMinute() * minutes;
    }
}

// Class representing the Fitness Tracker
class FitnessTracker {
    private List<User3> User3s;

    public FitnessTracker() {
        User3s = new ArrayList<>();
    }

    public void addUser3 (User3 User3) {
        User3s.add(User3);
        System.out.println("User3  added: " + User3.getUser3name());
    }

    public void logUser3Workout(String User3name, Workout workout) {
        for (User3  User3 : User3s) {
            if (User3.getUser3name().equalsIgnoreCase(User3name)) {
                User3.logWorkout(workout);
                return;
            }
        }
        System.out.println("User3  not found: " + User3name);
    }

    public void displayAllWorkouts() {
        for (User3  User3 : User3s) {
            User3.displayWorkouts();
        }
    }
}

// Main class to run the Fitness Tracker
public class p20 {
    public static void main(String[] args) {
        // Create a fitness tracker
        FitnessTracker fitnessTracker = new FitnessTracker();

        // Create User3s
        User3 User31 = new User3("Alice");
        User3 User32 = new User3("Bob");

        // Add User3s to the fitness tracker
        fitnessTracker.addUser3 (User31);
        fitnessTracker.addUser3 (User32);

        // Create activities
        Activity running = new Activity("Running", 10); // 10 calories per minute
        Activity cycling = new Activity("Cycling", 8); // 8 calories per minute

        // Log workouts for User3s
        Workout workout1 = new Workout("2023-10-01");
        workout1.addActivity(running);
        workout1.addActivity(cycling);

        Workout workout2 = new Workout("2023-10-02");
        workout2.addActivity(running);

        fitnessTracker.logUser3Workout("Alice", workout1);
        fitnessTracker.logUser3Workout("Bob", workout2);

        // Display all workouts
        fitnessTracker.displayAllWorkouts();
    }
}
