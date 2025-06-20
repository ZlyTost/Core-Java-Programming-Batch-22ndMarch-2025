package Day11;
//A library management system to manage books and members.

//Class representing a book
class Book {
 private String title;
 private String author;
 private final String isbn; // Final variable

 // Constructor
 public Book(String title, String author, String isbn) {
     this.title = title;
     this.author = author;
     this.isbn = isbn;
 }

 // Method to get book details
 public String getDetails() {
     return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
 }
}

public class p25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
