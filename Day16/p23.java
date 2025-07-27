package Day16;

//----------------------------------- Example 1: Basic Encapsulation -----------------------------------

/*
 * This class demonstrates the concept of encapsulation in Java.
 * Encapsulation is the process of hiding the internal state (data) of an object 
 * and allowing access through public methods (getters and setters).
 */
class Employee {
    // Private data members - only accessible within this class
    private String name;
    private int id;

    // Public getter method for 'name'
    // Allows other classes to read the value of 'name'
    public String getName() {
        return name;
    }

    // Public setter method for 'name'
    // Allows other classes to set the value of 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Public getter method for 'id'
    // Allows other classes to read the value of 'id'
    public int getId() {
        return id;
    }

    // Public setter method for 'id'
    // Allows other classes to set the value of 'id'
    public void setId(int id) {
        this.id = id;
    }
}

// Main class to test the Employee class
public class p23 {
    public static void main(String[] args) {

        // Creating an object of Employee class
        Employee emp = new Employee();

        // Setting values using setter methods
        emp.setName("John Doe");
        emp.setId(101);

        // Getting and displaying values using getter methods
        System.out.println("Employee Name: " + emp.getName());  // Output: Employee Name: John Doe
        System.out.println("Employee ID: " + emp.getId());      // Output: Employee ID: 101
    }
}
