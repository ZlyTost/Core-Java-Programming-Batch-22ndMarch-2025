package Day15;

public class p8 {
//Program 24: Find First Non-Repeating Character
	public static void main(String[] args) {
		 String s = "swiss";
	        for (char c : s.toCharArray()) {
	            if (s.indexOf(c) == s.lastIndexOf(c)) {
	                System.out.println("First non-repeating char: " + c);
	                break;
	            }
	        }
	}
}
