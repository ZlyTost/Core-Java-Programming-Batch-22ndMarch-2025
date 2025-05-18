package Day7;
//Program 3: Method with Parameters
class Greeting {
    void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}

public class P11 {
    public static void main(String[] args) {
        Greeting g = new Greeting();
        g.sayHello("Shalini");
    }
}
