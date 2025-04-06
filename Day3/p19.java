package Day3;

import java.util.Scanner;

public class p19 {
    // Score Tracker
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        double[] scores = new double[numSubjects];
        double totalScore = 0;

        // Input scores for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
            totalScore += scores[i];
        }

        // Calculate average score
        double averageScore = totalScore / numSubjects;

        // Display results
        System.out.println("\n--- Score Summary ---");
        System.out.println("Total Score: " + totalScore);
        System.out.printf("Average Score: %.2f%n", averageScore);
        
        // Optional: Display individual scores
        System.out.println("\nIndividual Scores:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("Subject %d: %.2f%n", (i + 1), scores[i]);
        }

        scanner.close();
    }
}