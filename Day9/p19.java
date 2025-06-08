package Day9;

import java.util.*;

// Base class representing a generic Course in an Online Course Platform
abstract class Course {
    protected String courseId;
    protected String title;
    protected String instructor;
    protected int totalModules;
    protected int completedModules;

    public Course(String courseId, String title, String instructor, int totalModules) {
        this.courseId = courseId;
        this.title = title;
        this.instructor = instructor;
        this.totalModules = totalModules;
        this.completedModules = 0;
    }

    // Abstract method for delivering content (differs by course type)
    public abstract void deliverContent(int moduleNumber);

    // Track progress by completing a module
    public void completeModule(int moduleNumber) {
        if (moduleNumber > totalModules || moduleNumber < 1) {
            System.out.println("Invalid module number.");
            return;
        }
        if (moduleNumber <= completedModules) {
            System.out.println("Module " + moduleNumber + " already completed.");
            return;
        }
        completedModules = moduleNumber;
        System.out.println("Completed module " + moduleNumber + " of course '" + title + "'");
    }

    // Calculate progress percentage
    public double getProgressPercent() {
        return (completedModules * 100.0) / totalModules;
    }

    // Abstract method to issue certificate upon completion
    public abstract void issueCertificate();

    // Display general course info and progress
    public void displayInfo() {
        System.out.println("Course ID     : " + courseId);
        System.out.println("Title         : " + title);
        System.out.println("Instructor    : " + instructor);
        System.out.println("Modules       : " + completedModules + " / " + totalModules);
        System.out.printf("Progress      : %.2f%%\n", getProgressPercent());
    }
}

// VideoCourse subclass with video-specific attributes and behavior
class VideoCourse extends Course {
    private int totalVideoHours;
    private boolean subtitlesAvailable;

    public VideoCourse(String courseId, String title, String instructor, int totalModules, int totalVideoHours, boolean subtitlesAvailable) {
        super(courseId, title, instructor, totalModules);
        this.totalVideoHours = totalVideoHours;
        this.subtitlesAvailable = subtitlesAvailable;
    }

    @Override
    public void deliverContent(int moduleNumber) {
        System.out.println("Streaming video module " + moduleNumber + " of '" + title + "' (" + totalVideoHours / totalModules + " hours approx.)");
        if (subtitlesAvailable) {
            System.out.println("Subtitles available for this module.");
        }
    }

    @Override
    public void issueCertificate() {
        if (completedModules == totalModules) {
            System.out.println("Issuing certificate for Video Course '" + title + "' to student.");
        } else {
            System.out.println("Cannot issue certificate. Complete all modules first.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Video Course ===");
        super.displayInfo();
        System.out.println("Total Video Hours   : " + totalVideoHours);
        System.out.println("Subtitles Available : " + (subtitlesAvailable ? "Yes" : "No"));
        System.out.println("-------------------------");
    }
}

// TextCourse subclass with text-specific features like downloadable PDFs
class TextCourse extends Course {
    private int totalPages;
    private boolean downloadablePDF;

    public TextCourse(String courseId, String title, String instructor, int totalModules, int totalPages, boolean downloadablePDF) {
        super(courseId, title, instructor, totalModules);
        this.totalPages = totalPages;
        this.downloadablePDF = downloadablePDF;
    }

    @Override
    public void deliverContent(int moduleNumber) {
        System.out.println("Displaying text module " + moduleNumber + " of '" + title + "' (~" + totalPages / totalModules + " pages)");
        if (downloadablePDF) {
            System.out.println("This module PDF is downloadable.");
        }
    }

    @Override
    public void issueCertificate() {
        if (completedModules == totalModules) {
            System.out.println("Issuing certificate for Text Course '" + title + "' to student.");
        } else {
            System.out.println("Complete all modules before receiving certificate.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Text Course ===");
        super.displayInfo();
        System.out.println("Total Pages         : " + totalPages);
        System.out.println("Downloadable PDF    : " + (downloadablePDF ? "Yes" : "No"));
        System.out.println("-------------------------");
    }
}

// InteractiveCourse subclass with quizzes and assignments
class InteractiveCourse extends Course {
    private int numQuizzes;
    private int numAssignments;
    private Map<Integer, Boolean> quizResults;  // Quiz number -> pass/fail

    public InteractiveCourse(String courseId, String title, String instructor, int totalModules, int numQuizzes, int numAssignments) {
        super(courseId, title, instructor, totalModules);
        this.numQuizzes = numQuizzes;
        this.numAssignments = numAssignments;
        this.quizResults = new HashMap<>();
    }

    @Override
    public void deliverContent(int moduleNumber) {
        System.out.println("Interactive content for module " + moduleNumber + " of '" + title + "'");
        System.out.println("Complete quizzes and assignments for full experience.");
    }

    // Submit quiz result for a quiz number
    public void submitQuizResult(int quizNumber, boolean passed) {
        if (quizNumber < 1 || quizNumber > numQuizzes) {
            System.out.println("Invalid quiz number.");
            return;
        }
        quizResults.put(quizNumber, passed);
        System.out.println("Quiz " + quizNumber + " submission recorded: " + (passed ? "Passed" : "Failed"));
    }

    @Override
    public void issueCertificate() {
        boolean allQuizzesPassed = quizResults.size() == numQuizzes && quizResults.values().stream().allMatch(Boolean::booleanValue);
        if (completedModules == totalModules && allQuizzesPassed) {
            System.out.println("Issuing certificate for Interactive Course '" + title + "' to student.");
        } else {
            System.out.println("Cannot issue certificate. Complete all modules and pass all quizzes first.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Interactive Course ===");
        super.displayInfo();
        System.out.println("Quizzes             : " + numQuizzes);
        System.out.println("Assignments         : " + numAssignments);
        System.out.println("Quiz Results        : " + (quizResults.isEmpty() ? "No quizzes taken" : quizResults));
        System.out.println("-------------------------");
    }
}

// Main class demonstrating the Online Course Platform
public class p19 {
    public static void main(String[] args) {
        System.out.println("=== Online Course Platform ===\n");

        VideoCourse videoCourse = new VideoCourse("VC101", "Java Programming", "Dr. Smith", 10, 25, true);
        videoCourse.displayInfo();
        videoCourse.deliverContent(1);
        videoCourse.completeModule(3);
        videoCourse.issueCertificate();  // Should not issue, incomplete

        System.out.println();

        TextCourse textCourse = new TextCourse("TC202", "History of Art", "Prof. Martin", 8, 200, false);
        textCourse.displayInfo();
        textCourse.deliverContent(2);
        textCourse.completeModule(8);
        textCourse.issueCertificate();  // Should issue certificate

        System.out.println();

        InteractiveCourse interactiveCourse = new InteractiveCourse("IC303", "Data Structures", "Ms. Lee", 12, 3, 4);
        interactiveCourse.displayInfo();
        interactiveCourse.deliverContent(1);
        interactiveCourse.completeModule(12);
        interactiveCourse.submitQuizResult(1, true);
        interactiveCourse.submitQuizResult(2, true);
        interactiveCourse.submitQuizResult(3, false);
        interactiveCourse.issueCertificate();  // Should not issue certificate due to failed quiz

        // Now pass last quiz and try again
        interactiveCourse.submitQuizResult(3, true);
        interactiveCourse.issueCertificate();  // Should issue certificate now
    }
}
