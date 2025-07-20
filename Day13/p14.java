package Day13;
//Example 3: Copying Student Marks
class Marks {
    int math, science;

    Marks(int m, int s) {
        math = m;
        science = s;
    }

    Marks(Marks m) {
        this.math = m.math;
        this.science = m.science;
    }
}

public class p14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
