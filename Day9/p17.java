package Day9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Base class representing a generic Media item in the library
abstract class Media {
    protected String title;
    protected String mediaId;
    protected boolean isBorrowed;
    protected LocalDate dueDate;

    public Media(String title, String mediaId) {
        this.title = title;
        this.mediaId = mediaId;
        this.isBorrowed = false;
        this.dueDate = null;
    }

    // Abstract method defining borrowing period in days
    protected abstract int getBorrowPeriodDays();

    // Abstract method defining daily late fee
    protected abstract double getLateFeePerDay();

    // Borrow the media item if available
    public boolean borrowItem(LocalDate borrowDate) {
        if (isBorrowed) {
            System.out.println(title + " (ID: " + mediaId + ") is already borrowed.");
            return false;
        }
        isBorrowed = true;
        dueDate = borrowDate.plusDays(getBorrowPeriodDays());
        System.out.println(title + " borrowed successfully. Due date: " + dueDate);
        return true;
    }

    // Return the media item and calculate fine if any
    public double returnItem(LocalDate returnDate) {
        if (!isBorrowed) {
            System.out.println(title + " (ID: " + mediaId + ") was not borrowed.");
            return 0.0;
        }
        isBorrowed = false;
        double fine = 0.0;
        if (returnDate.isAfter(dueDate)) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
            fine = daysLate * getLateFeePerDay();
            System.out.println("Returned late by " + daysLate + " day(s). Fine: ₹" + fine);
        } else {
            System.out.println("Returned on time. No fine.");
        }
        dueDate = null;
        return fine;
    }

    // Check availability status
    public boolean isAvailable() {
        return !isBorrowed;
    }

    // Display item info including availability
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Media ID: " + mediaId);
        System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
        if (isBorrowed) {
            System.out.println("Due Date: " + dueDate);
        }
    }
}

// Book class with specific borrow period and late fees
class Book extends Media {
    private String author;
    private int numPages;

    public Book(String title, String mediaId, String author, int numPages) {
        super(title, mediaId);
        this.author = author;
        this.numPages = numPages;
    }

    @Override
    protected int getBorrowPeriodDays() {
        return 21; // 3 weeks borrowing period for books
    }

    @Override
    protected double getLateFeePerDay() {
        return 2.0; // ₹2 fine per day late for books
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Book ===");
        super.displayInfo();
        System.out.println("Author: " + author);
        System.out.println("Pages: " + numPages);
        System.out.println("Borrow Period: " + getBorrowPeriodDays() + " days");
        System.out.println("Late Fee/Day: ₹" + getLateFeePerDay());
        System.out.println("----------------------------");
    }
}

// DVD class with shorter borrowing period and higher late fees
class DVD extends Media {
    private int durationMinutes; // length of DVD
    private String director;

    public DVD(String title, String mediaId, int durationMinutes, String director) {
        super(title, mediaId);
        this.durationMinutes = durationMinutes;
        this.director = director;
    }

    @Override
    protected int getBorrowPeriodDays() {
        return 7; // 1 week borrowing period for DVDs
    }

    @Override
    protected double getLateFeePerDay() {
        return 5.0; // ₹5 fine per day late for DVDs
    }

    @Override
    public void displayInfo() {
        System.out.println("=== DVD ===");
        super.displayInfo();
        System.out.println("Duration: " + durationMinutes + " minutes");
        System.out.println("Director: " + director);
        System.out.println("Borrow Period: " + getBorrowPeriodDays() + " days");
        System.out.println("Late Fee/Day: ₹" + getLateFeePerDay());
        System.out.println("----------------------------");
    }
}

// Magazine class with shortest borrowing period and lowest late fees
class Magazine extends Media {
    private String issueMonth;

    public Magazine(String title, String mediaId, String issueMonth) {
        super(title, mediaId);
        this.issueMonth = issueMonth;
    }

    @Override
    protected int getBorrowPeriodDays() {
        return 14; // 2 weeks borrowing period for magazines
    }

    @Override
    protected double getLateFeePerDay() {
        return 1.0; // ₹1 fine per day for magazines
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Magazine ===");
        super.displayInfo();
        System.out.println("Issue Month: " + issueMonth);
        System.out.println("Borrow Period: " + getBorrowPeriodDays() + " days");
        System.out.println("Late Fee/Day: ₹" + getLateFeePerDay());
        System.out.println("----------------------------");
    }
}

// Main class demonstrating the Library Management System
public class p17 {
    public static void main(String[] args) {
        System.out.println("*** Library Management System ***\n");

        // Create sample media items
        Book book1 = new Book("Effective Java", "B101", "Joshua Bloch", 416);
        DVD dvd1 = new DVD("Inception", "D202", 148, "Christopher Nolan");
        Magazine mag1 = new Magazine("National Geographic", "M303", "October 2024");

        // Display info
        book1.displayInfo();
        dvd1.displayInfo();
        mag1.displayInfo();

        // Borrow items
        System.out.println("\nBorrowing Items...");
        book1.borrowItem(LocalDate.of(2024, 10, 1));
        dvd1.borrowItem(LocalDate.of(2024, 10, 1));
        mag1.borrowItem(LocalDate.of(2024, 10, 1));

        // Display availability after borrowing
        System.out.println();
        book1.displayInfo();
        dvd1.displayInfo();
        mag1.displayInfo();

        // Return items - some returned late, some on time
        System.out.println("\nReturning Items...");
        book1.returnItem(LocalDate.of(2024, 10, 25)); // 3 days late (due 22 Oct)
        dvd1.returnItem(LocalDate.of(2024, 10, 7));  // on time
        mag1.returnItem(LocalDate.of(2024, 10, 15));  // on time

        // Display availability after return
        System.out.println();
        book1.displayInfo();
        dvd1.displayInfo();
        mag1.displayInfo();
    }
}
