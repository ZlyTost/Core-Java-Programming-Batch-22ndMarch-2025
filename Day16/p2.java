package Day16;

// Java program to convert object into primitives  
// Unboxing example of Integer to int 
public class p2 {

    public static void main(String[] args) {
        
        // Creating an Integer object (Wrapper Class)
        Integer a = new Integer(3);  // Deprecated in recent Java, prefer: Integer a = 3;

        // Explicit unboxing using intValue()
        int i = a.intValue();

        // Implicit unboxing (compiler converts object to primitive internally)
        int j = a;  // Compiler writes: a.intValue();

        // Display all values
        System.out.println(a + " " + i + " " + j);  
        // Output: 3 3 3
    }
}
