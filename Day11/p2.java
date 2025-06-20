package Day11;
//Example 3: To invoke current class constructor
class Person {
    String name;
    int age;

    Person() {
        this("Unknown", 0);  // Calls parameterized constructor
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void info() {
        System.out.println(name + " - " + age);
    }
}

public class p2 {

	public static void main(String[] args) {
		Person p = new Person("Anamika",24);
		
		p.info();
	}

}
