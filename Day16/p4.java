package Day16;

//------------------------------------ Encapsulation in Real-World Applications ------------------------------------

import java.util.ArrayList;
import java.util.List;

//---------------------------- Book Class (Encapsulated Entity) ----------------------------
/*
 * Represents a book in the library.
 * Encapsulates details like title, author, and availability.
 */
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor initializes book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, the book is available
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Check if the book is available
    public boolean isAvailable() {
        return isAvailable;
    }

    // Borrow the book (updates availability)
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is currently not available.");
        }
    }

    // Return the book (updates availability)
    public void returnBook() {
        isAvailable = true;
        System.out.println("You have returned: " + title);
    }
}

//---------------------------- Member Class (Encapsulated Behavior) ----------------------------
/*
 * Represents a library member.
 * Manages borrowing and returning of books while hiding internal list logic.
 */
class Member {
    private String name;
    private List<Book> borrowedBooks;

    // Constructor initializes member with a name and empty borrowed list
    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter for member name
    public String getName() {
        return name;
    }

    // Borrow a book if available and add to the member's list
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            borrowedBooks.add(book);
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    // Return a book if it exists in the member's list
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println("You did not borrow this book.");
        }
    }

    // List all books currently borrowed by this member
    public void listBorrowedBooks() {
        System.out.println(name + "'s Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}

//---------------------------- Library Class (Encapsulated System) ----------------------------
/*
 * Represents the entire library.
 * Maintains the list of all books and members and provides high-level methods.
 */
class Library {
    private List<Book> books;
    private List<Member> members;

    // Constructor initializes the library with empty lists
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    // Add a new member to the library
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Added member: " + member.getName());
    }

    // Display all books with their availability status
    public void listBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " (Available: " + book.isAvailable() + ")");
        }
    }
}

//---------------------------- Main Class to Run the Application ----------------------------
public class p4 {
    public static void main(String[] args) {
        // Step 1: Create a Library instance
        Library library = new Library();

        // Step 2: Create Book instances
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Step 3: Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Step 4: Create Member instances
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");

        // Step 5: Add members to the library
        library.addMember(member1);
        library.addMember(member2);

        // Step 6: List available books in the library
        library.listBooks();

        // Step 7: Members borrow books
        member1.borrowBook(book1); // Alice borrows book1
        member2.borrowBook(book2); // Bob borrows book2

        // Step 8: List borrowed books for each member
        member1.listBorrowedBooks();
        member2.listBorrowedBooks();

        // Step 9: Try borrowing an already borrowed book
        member1.borrowBook(book1); // Should indicate not available

        // Step 10: Members return books
        member1.returnBook(book1);
        member2.returnBook(book2);

        // Step 11: List books again to check availability updates
        library.listBooks();
    }
}
