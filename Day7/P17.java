package Day7;
// Program 9: Class with Constructor
class Animal1 {
    Animal1() {
        System.out.println("Animal created");
    }

    void sound() {
        System.out.println("Animal sound");
    }
}

public class P17{
    public static void main(String[] args) {
        Animal1 a = new Animal1();
        a.sound();
    }
}
