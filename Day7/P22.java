package Day7;
//Program 15: Employee Salary Calculation
class Employee {
    String name;
    int basic;

    void setData(String n, int b) {
        name = n;
        basic = b;
    }

    void showSalary() {
        double hra = 0.2 * basic;
        double da = 0.1 * basic;
        double total = basic + hra + da;
        System.out.println("Total salary of " + name + ": " + total);
    }
}

public class P22 {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setData("Jay", 20000);
        e.showSalary();
    }
}
