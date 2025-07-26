package Day16;

// Java program to convert primitive into objects  
// Autoboxing example of int to Integer  
public class p19 {

    public static void main(String[] args) {
        
        // Primitive int value
        int a = 20;

        // Converting int into Integer explicitly using valueOf() method
        Integer i = Integer.valueOf(a);  // Manual Boxing

        // Autoboxing: compiler automatically converts int to Integer
        // This line is internally treated as: Integer j = Integer.valueOf(a);
        Integer j = a;

        // Displaying all values to show they are the same
        System.out.println(a + " " + i + " " + j);
        // Output: 20 20 20
    }
}
