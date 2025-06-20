package Day11;
/*
  2. static keyword examples
static is used for class-level members, shared by all instances. 
 */

//a) Static variable

class Student {
    static String college = "ABC College";
    int roll;

    Student(int roll) {
        this.roll = roll;
    }

    void show() {
        System.out.println(roll + " " + college);
    }
}

public class p12 {

	public static void main(String[] args) {
		Student stu = new Student(1);

		stu.show();
	}

}
