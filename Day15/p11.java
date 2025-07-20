package Day15;

public class p11 {
// Program 3: Difference between literals and objects
	 public static void main(String[] args) {
	    // s1 refers to a string literal, which is stored in the String pool
	    String s1 = "Hello";

	   // s2 also refers to the same string literal "Hello" in the pool, so s1 and s2 point to the same object
	    String s2 = "Hello";

	   System.out.println(s1 == s2); // true → both refer to the same object in the String pool

	   // s3 is created using the 'new' keyword, so it refers to a new object in the heap, not the pool
	   String s3 = new String("Hello");

	   System.out.println(s1 == s3); // false → different memory locations (s1 in pool, s3 in heap)

	  // s4 is assigned the interned value of s3
	 // intern() checks if the same content is in the pool, and returns reference to that pooled object
	  String s4 = s3.intern();

	        System.out.println(s1 == s4); // true → s4 now refers to the same object as s1 in the pool
	     // Real-Time Example: Optimizing memory by reusing string literals.
	    }
	}