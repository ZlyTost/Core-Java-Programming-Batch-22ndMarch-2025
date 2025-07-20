package Day15;

public class p5 {
//Program 21: Reverse Each Word
	public static void main(String[] args) {
		 String line = "Hello Java World";
	        for (String word : line.split(" ")) {
	            System.out.print(new StringBuilder(word).reverse() + " ");
	        }
	}

}
