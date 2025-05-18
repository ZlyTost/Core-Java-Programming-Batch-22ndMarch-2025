package Day7;
//Program 13: Area of Circle
class Circle {
    double radius;

    void setRadius(double r) {
        radius = r;
    }

    void area() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of circle: " + area);
    }
}

public class P20 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(7);
        c.area();
    }
}
