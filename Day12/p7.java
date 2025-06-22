package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 23. Library Reservation System
Description: A library reservation system that allows users to reserve 
books and view their reservations.
 */
//Interface for Library Reservation Operations
interface LibraryReservationOperations {
 void reserveBook(String bookTitle);
 void viewReservations();
}

//Class representing a Library Reservation Manager
class LibraryReservationManager implements LibraryReservationOperations {
 private List<String> reservations = new ArrayList<>();

 @Override
 public void reserveBook(String bookTitle) {
     reservations.add(bookTitle);
     System.out.println("Reserved book: " + bookTitle);
 }

 @Override
 public void viewReservations() {
     System.out.println("Reserved Books: " + reservations);
 }
}

//Main class to test the Library Reservation System
public class p7 {
 public static void main(String[] args) {
     LibraryReservationManager manager = new LibraryReservationManager();
     manager.reserveBook("The Great Gatsby");
     manager.reserveBook("1984");
     manager.viewReservations();
 }
}
