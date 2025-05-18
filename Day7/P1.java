package Day7;
// Program 1: Basic Class and Object
class Student {
    void showDetails() {
        System.out.println("Name: Rahul");
        System.out.println("Age: 20");
    }
}

public class P1 {
    public static void main(String[] args) {
        Student s = new Student(); // Creating object
        s.showDetails();           // Calling method
    }
}
