package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Library1 Book Search: 
Implement a class Library1 with methods to search for books 
by title, author, or ISBN.
*/

// Interface defining search behavior
interface Searchable {
    boolean matchesTitle(String title);
    boolean matchesAuthor(String author);
    boolean matchesISBN(String isbn);
}

// Base class for Library1 items (can be expanded for other item types)
abstract class Library1Item implements Searchable {
    protected String title;
    protected String author;
    protected String isbn;

    public Library1Item(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean matchesTitle(String title) {
        return this.title != null && this.title.toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public boolean matchesAuthor(String author) {
        return this.author != null && this.author.toLowerCase().contains(author.toLowerCase());
    }

    @Override
    public boolean matchesISBN(String isbn) {
        return this.isbn != null && this.isbn.equalsIgnoreCase(isbn);
    }

    public abstract void displayDetails();
}

// Class representing different book categories (demonstrates inheritance)
class BookCategory extends Library1Item {
    private String categoryName;

    public BookCategory(String title, String author, String isbn, String categoryName) {
        super(title, author, isbn);
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("ISBN    : " + isbn);
        System.out.println("Category: " + categoryName);
        System.out.println("--------------------------");
    }
}

// Main class representing the Library1
class Library1 {
    private List<Library1Item> books;

    public Library1() {
        books = new ArrayList<>();
    }

    // Method to add a book to the Library1
    public void addBook(Library1Item book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    // Search books by title (supports partial search)
    public List<Library1Item> searchByTitle(String title) {
        List<Library1Item> result = new ArrayList<>();
        for (Library1Item book : books) {
            if (book.matchesTitle(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Search books by author (supports partial search)
    public List<Library1Item> searchByAuthor(String author) {
        List<Library1Item> result = new ArrayList<>();
        for (Library1Item book : books) {
            if (book.matchesAuthor(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Search books by exact ISBN
    public Library1Item searchByISBN(String isbn) {
        for (Library1Item book : books) {
            if (book.matchesISBN(isbn)) {
                return book;
            }
        }
        return null; // Not found
    }

    // Display search results
    public void displayBooks(List<Library1Item> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Library1Item book : books) {
            book.displayDetails();
        }
    }
}

// Main class with demo usage
public class p2 {
    public static void main(String[] args) {
        Library1 Library1 = new Library1();

        // Add books
        Library1.addBook(new BookCategory("Effective Java", "Joshua Bloch", "9780134685991", "Programming"));
        Library1.addBook(new BookCategory("Clean Code", "Robert C. Martin", "9780132350884", "Programming"));
        Library1.addBook(new BookCategory("The Hobbit", "J.R.R. Tolkien", "9780547928227", "Fantasy"));
        Library1.addBook(new BookCategory("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "9780590353427", "Fantasy"));

        // Search examples
        System.out.println("\nSearch Results for Title containing 'clean':");
        Library1.displayBooks(Library1.searchByTitle("clean"));

        System.out.println("\nSearch Results for Author containing 'martin':");
        Library1.displayBooks(Library1.searchByAuthor("martin"));

        System.out.println("\nSearch Result for ISBN 9780547928227:");
        Library1Item book = Library1.searchByISBN("9780547928227");
        if (book != null) {
            book.displayDetails();
        } else {
            System.out.println("Book not found.");
        }
    }
}
