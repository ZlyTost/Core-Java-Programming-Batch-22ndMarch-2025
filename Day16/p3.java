package Day16;

//------------------------------- Example 4: Write-Only Class -------------------------------

/*
 * This example demonstrates how to create a write-only class using encapsulation.
 * In a write-only class, the private data can be set (written to) from outside the class
 * using setter methods, but cannot be read (no getter methods are provided).
 */
class WriteOnlyPerson {
    // Private field to store the name
    private String name;

    // Public setter method to allow writing the name
    public void setName(String name) {
        this.name = name;
    }

    // No getter method is provided
    // So, once the value is set, it cannot be read from outside the class
}

// Main class to test the WriteOnlyPerson class
public class p3 {
    public static void main(String[] args) {
        // Create a new WriteOnlyPerson object
        WriteOnlyPerson person = new WriteOnlyPerson();

        // Set the name using the setter method
        person.setName("Bob");

        // Attempting to read the name will cause a compilation error
        // because there is no getter method provided.
        // System.out.println(person.getName()); // ❌ Compilation Error
    }
}
