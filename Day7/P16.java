package Day7;
//Program 8: Method Overloading
class Display {
    void show() {
        System.out.println("Hello!");
    }

    void show(String name) {
        System.out.println("Hello " + name + "!");
    }
}

public class P16 {
    public static void main(String[] args) {
        Display d = new Display();
        d.show();
        d.show("Kavita");
    }
}
