package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 2. Library Management System
Description: A library management system that allows adding books, 
borrowing, and returning books.
 */
//Interface for Library Operations
interface LibraryOperations {
 void addBook(String title);
 void borrowBook(String title);
 void returnBook(String title);
}

//Class representing a Library
class Library implements LibraryOperations {
 private List<String> books = new ArrayList<>();

 @Override
 public void addBook(String title) {
     books.add(title);
     System.out.println("Added book: " + title);
 }

 @Override
 public void borrowBook(String title) {
     if (books.contains(title)) {
         books.remove(title);
         System.out.println("Borrowed book: " + title);
     } else {
         System.out.println("Book not available.");
     }
 }

 @Override
 public void returnBook(String title) {
     books.add(title);
     System.out.println("Returned book: " + title);
 }
}

//Main class to test the Library Management System
public class p10 {
 public static void main(String[] args) {
     Library library = new Library();
     library.addBook("Java Programming");
     library.borrowBook("Java Programming");
     library.returnBook("Java Programming");
 }
}
