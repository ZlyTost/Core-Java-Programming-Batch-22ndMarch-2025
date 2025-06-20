package Day11;
//A simple online quiz system to manage questions and answers.

//Class representing a question
class Question {
 private String questionText;
 private String answer;

 // Constructor
 public Question(String questionText, String answer) {
     this.questionText = questionText;
     this.answer = answer;
 }

 // Method to check answer
 public boolean checkAnswer(String userAnswer) {
     return answer.equalsIgnoreCase(userAnswer);
 }

 // Method to display question
 public void display() {
     System.out.println("Question: " + questionText);
 }
}

public class p7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
