package Day7;
//Program 14: Student Marks with Average
class Marks {
    int m1, m2, m3;

    void setMarks(int a, int b, int c) {
        m1 = a;
        m2 = b;
        m3 = c;
    }

    void average() {
        int avg = (m1 + m2 + m3) / 3;
        System.out.println("Average Marks: " + avg);
    }
}

public class P21 {
    public static void main(String[] args) {
        Marks m = new Marks();
        m.setMarks(70, 80, 90);
        m.average();
    }
}
