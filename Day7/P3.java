package Day7;
// Program 19: Table of a Number
class Table {
    void printTable(int num) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}

public class P3{
    public static void main(String[] args) {
        Table t = new Table();
        t.printTable(7);
    }
}
