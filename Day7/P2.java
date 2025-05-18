package Day7;
//Program 12: Area of Rectangle
class Rectangle {
    int length, breadth;

    void setData(int l, int b) {
        length = l;
        breadth = b;
    }

    void area() {
        int area = length * breadth;
        System.out.println("Area of rectangle: " + area);
    }
}

public class P2 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setData(10, 5);
        r.area();
    }
}
