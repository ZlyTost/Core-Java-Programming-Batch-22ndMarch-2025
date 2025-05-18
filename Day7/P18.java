package Day7;
//Program 10: Constructor with Parameters
class Car {
    String model;
    int year;

    Car(String m, int y) {
        model = m;
        year = y;
    }

    void showDetails() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
}

public class P18 {
    public static void main(String[] args) {
        Car c = new Car("Honda City", 2023);
        c.showDetails();
    }
}
