package Day16;

//------------------------------- Example 3: Read-Only Class -------------------------------

/*
 * This example demonstrates how to create a read-only class using encapsulation.
 * The class allows data (name) to be read but not modified after the object is created.
 * This is done by providing only a getter method and no setter method.
 */
class ReadOnlyPerson {
    // Private field to store the name
    private String name;

    // Constructor to initialize the name at the time of object creation
    public ReadOnlyPerson(String name) {
        this.name = name;
    }

    // Public getter method to access the name
    public String getName() {
        return name;
    }

    // No setter method is provided, so the name cannot be changed once set
}

// Main class to test the ReadOnlyPerson class
public class p25 {
    public static void main(String[] args) {
        // Create a new ReadOnlyPerson object with the name "Alice"
        ReadOnlyPerson person = new ReadOnlyPerson("Alice");

        // Print the name using the getter method
        System.out.println("Person Name: " + person.getName());  // Output: Person Name: Alice

        // Uncommenting the below line would cause a compilation error
        // because 'name' is private and there is no setter method to modify it.
        // person.name = "Bob";
    }
}
