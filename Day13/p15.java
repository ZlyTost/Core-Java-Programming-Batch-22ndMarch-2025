package Day13;
/*
 3. Constructor Chaining
One constructor calls another constructor using this().
 */

//Example 1: Student5 Admission
class Student5 {
    String name;
    int age;

    Student5() {
        this("Unknown", 18);  // default
    }

    Student5(String name) {
        this(name, 18);  // age default
    }

    Student5(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class p15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
