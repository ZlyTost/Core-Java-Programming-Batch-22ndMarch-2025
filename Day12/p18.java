package Day12;
/*
 10. Online Quiz System
Description: An online quiz system that allows users to take quizzes 
and view their scores.
 */
//Abstract class representing a Quiz
abstract class Quiz {
 protected String quizName;
 protected int score;

 public Quiz(String quizName) {
     this.quizName = quizName;
     this.score = 0;
 }

 public abstract void takeQuiz();
 public abstract void displayScore();
}

//Class representing a General Knowledge Quiz
class GeneralKnowledgeQuiz extends Quiz {
 public GeneralKnowledgeQuiz(String quizName) {
     super(quizName);
 }

 @Override
 public void takeQuiz() {
     // Simulate taking the quiz and scoring
     score = 80; // Example score
     System.out.println("Quiz taken: " + quizName);
 }

 @Override
 public void displayScore() {
     System.out.println("Score for " + quizName + ": " + score);
 }
}

//Main class to test the Online Quiz System
public class p18 {
 public static void main(String[] args) {
     Quiz quiz = new GeneralKnowledgeQuiz("General Knowledge Quiz");
     quiz.takeQuiz();
     quiz.displayScore();
 }
}
