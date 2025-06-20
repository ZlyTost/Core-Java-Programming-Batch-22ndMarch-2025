package Day11;
//A simple fitness tracker to manage workouts.

//Class representing a workout
class Workout {
 private String type;
 private int duration; // in minutes

 // Constructor
 public Workout(String type, int duration) {
     this.type = type;
     this.duration = duration;
 }

 // Method to display workout details
 public void display() {
     System.out.println("Workout Type: " + type + ", Duration: " + duration + " minutes");
 }
}

public class p9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
