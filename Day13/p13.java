package Day13;
//Example 2: Copying Book Details
class Book {
    String title;
    int pages;

    Book(String t, int p) {
        title = t;
        pages = p;
    }

    Book(Book b) {
        title = b.title;
        pages = b.pages;
    }
}

public class p13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
