package Day15;

public class p17 {
//Program 9: equals() vs ==
	public static void main(String[] args) {
		  String a = "Test";
	        String b = new String("Test");
	        System.out.println(a == b); // false
	        System.out.println(a.equals(b)); // true
	}

}
