package Day11;
/*
 this Keyword -->
 
The this keyword refers to the current class object. 
It's used to eliminate confusion between class attributes and parameters, 
or to call another constructor or method from the current object. 
 */

// Example 1: To refer current class instance variable
class Student2 {
    int id;
    String name;

    Student2(int id, String name) {
        this.id = id;       // refers to instance variable
        this.name = name;   // refers to instance variable
    }

    void display() {
        System.out.println(id + " " + name);
    }
}

public class p18 {

	public static void main(String[] args) {
		Student2 stud = new Student2(1,"Kavya");
		stud.display();
	}

}
