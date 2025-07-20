package Day15;

public class p22 {
// Program 15: Remove Special Characters
	public static void main(String[] args) {
		  String input = "My#Name@Is$Java!";
	        String clean = input.replaceAll("[^a-zA-Z0-9 ]", "");
	        System.out.println(clean); // Output: MyNameIsJava
	}

}
