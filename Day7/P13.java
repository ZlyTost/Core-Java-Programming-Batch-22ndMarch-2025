package Day7;
//Program 5: Class with Instance Variables
public class P13 {
    public static void main(String[] args) {
    	Person person = new Person("Alice", 20);
        // Print student details
        person.printDetails();
    }
}

class Person {
    private String name;
    private int age;

    // Constructor to initialize name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to print student details
    public void printDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
