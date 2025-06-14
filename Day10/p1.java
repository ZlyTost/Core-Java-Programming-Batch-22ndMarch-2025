package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Library Management System: 
Create classes for Book, Member, Library, LibraryCard, and LibraryStaff. 
Implement methods for adding/removing books, registering members, 
and checking out books.
*/

// Class representing a Book
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // Book is available by default
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

// Class representing a Library Member
class Member {
    private String name;
    private String memberId;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}

// Class representing a Library Card
class LibraryCard {
    private Member member;
    private String cardNumber;

    public LibraryCard(Member member, String cardNumber) {
        this.member = member;
        this.cardNumber = cardNumber;
    }

    public Member getMember() {
        return member;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

// Class representing Library Staff (inherits from Member)
class LibraryStaff extends Member {
    private String staffId;

    public LibraryStaff(String name, String memberId, String staffId) {
        super(name, memberId);
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }
}

// Class representing the Library
class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book removed with ISBN: " + isbn);
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered: " + member.getName());
    }

    public void checkOutBook(String isbn, Member member) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println(member.getName() + " checked out: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available for checkout.");
    }
}

// Main class to run the Library Management System
public class p1 {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new Book("1984", "George Orwell", "123456789");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "987654321");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Create members
        Member member1 = new Member("Alice", "M001");
        Member member2 = new Member("Bob", "M002");

        // Register members
        library.registerMember(member1);
        library.registerMember(member2);

        // Check out a book
        library.checkOutBook("123456789", member1); // Alice checks out 1984
        library.checkOutBook("123456789", member2); // Bob tries to check out 1984 again

        // Remove a book
        library.removeBook("987654321"); // Remove "To Kill a Mockingbird"
    }
}
