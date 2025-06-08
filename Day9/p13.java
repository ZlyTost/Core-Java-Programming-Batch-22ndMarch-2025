package Day9;

//Interface 1 - Learner
interface Learner {
	void study();
	default void showIdentity() {
		System.out.println("I am a learner.");
	}
}

//Interface 2 - Player
interface Player {
	void play();
	default void showIdentity() {
		System.out.println("I am a player.");
	}
}

//Class - Student implements multiple interfaces
class Student implements Learner, Player {
	String name;
	int studyHours;
	int playHours;

	Student(String name, int studyHours, int playHours) {
		this.name = name;
		this.studyHours = studyHours;
		this.playHours = playHours;
	}

	// Method from Learner
	public void study() {
		System.out.println(name + " studies for " + studyHours + " hours daily.");
	}

	// Method from Player
	public void play() {
		System.out.println(name + " plays for " + playHours + " hours daily.");
	}

	// Overriding to resolve diamond problem
	@Override
	public void showIdentity() {
		System.out.println(name + " is both a Learner and a Player.");
	}
}

// Main Class
public class p13 {
	public static void main(String[] args) {

		System.out.println("\n======= Multiple Inheritance with Interfaces Example =======");

		Student s1 = new Student("Aryan", 5, 2);
		s1.study();           // From Learner
		s1.play();            // From Player
		s1.showIdentity();    // Resolved from both

		Student s2 = new Student("Kavya", 4, 4);
		s2.study();
		s2.play();
		s2.showIdentity();
	}
}
