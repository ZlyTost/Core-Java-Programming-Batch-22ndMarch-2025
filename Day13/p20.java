package Day13;
/*
  5. Constructor Overloading
Same constructor name with different parameters.
 */

//Example 1: Employee Data
class Employee {
    String name;
    int age;

    Employee() {
        this("Unknown", 0);
    }

    Employee(String name) {
        this(name, 25);  // default age
    }

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class p20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
