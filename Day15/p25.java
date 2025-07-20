package Day15;

import java.util.Arrays;

public class p25 {
//Program 18: Anagram Check
	public static void main(String[] args) {
		  String a = "listen";
	        String b = "silent";
	        char[] ac = a.toCharArray();
	        char[] bc = b.toCharArray();
	        Arrays.sort(ac);
	        Arrays.sort(bc);
	        System.out.println(Arrays.equals(ac, bc) ? "Anagram" : "Not Anagram");
	}

}
