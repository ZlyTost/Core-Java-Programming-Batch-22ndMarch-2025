package Day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Online Quiz Application: 
Design classes for Question, Quiz, and User1. 
Implement methods for adding questions, taking quizzes, and calculating scores.
*/

// Class representing a Question
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

// Class representing a Quiz
class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

// Class representing a User1
class User1 {
    private String User1name;

    public User1(String User1name) {
        this.User1name = User1name;
    }

    public String getUser1name() {
        return User1name;
    }
}

// Class representing an Answer
class Answer {
    private Question question;
    private int selectedOptionIndex;

    public Answer(Question question, int selectedOptionIndex) {
        this.question = question;
        this.selectedOptionIndex = selectedOptionIndex;
    }

    public boolean isCorrect() {
        return question.isCorrectAnswer(selectedOptionIndex);
    }
}

// Class representing the Quiz Application
class QuizApplication {
    private Quiz quiz;
    private User1 User1;

    public QuizApplication(User1 User1) {
        this.User1 = User1;
        this.quiz = new Quiz();
    }

    public void addQuestionToQuiz(Question question) {
        quiz.addQuestion(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        List<Answer> answers = new ArrayList<>();

        System.out.println("Quiz for User1: " + User1.getUser1name());
        for (Question question : quiz.getQuestions()) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Select an option (1-" + options.length + "): ");
            int selectedOption = scanner.nextInt() - 1; // Convert to zero-based index
            answers.add(new Answer(question, selectedOption));
        }

        calculateScore(answers);
        scanner.close();
    }

    private void calculateScore(List<Answer> answers) {
        int score = 0;
        for (Answer answer : answers) {
            if (answer.isCorrect()) {
                score++;
            }
        }
        System.out.println("Your score: " + score + "/" + quiz.getQuestions().size());
    }
}

// Main class to run the Online Quiz Application
public class p16 {
    public static void main(String[] args) {
        // Create a User1
        User1 User1 = new User1("Alice");

        // Create a quiz application for the User1
        QuizApplication quizApp = new QuizApplication(User1);

        // Add questions to the quiz
        quizApp.addQuestionToQuiz(new Question("What is the capital of France?", 
            new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2));
        quizApp.addQuestionToQuiz(new Question("Which planet is known as the Red Planet?", 
            new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1));
        quizApp.addQuestionToQuiz(new Question("What is the largest ocean on Earth?", 
            new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3));

        // User1 takes the quiz
        quizApp.takeQuiz();
    }
}
