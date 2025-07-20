package Day15;

public class p24 {
// Program 17: Palindrome Check
	public static void main(String[] args) {
		 String str = "madam";
	        String reversed = new StringBuilder(str).reverse().toString();
	        System.out.println(str.equals(reversed) ? "Palindrome" : "Not Palindrome");
	}

}
