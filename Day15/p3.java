package Day15;

public class p3 {
//Program 19: Count Characters
	public static void main(String[] args) {
		 String s = "Banana";
	        int count = s.length() - s.replace("a", "").length();
	        System.out.println("a occurs: " + count + " times");
	}

}
