package Day13;
//Example 2: Cloneable – Cloning Objects
class Employee implements Cloneable { // Marker interface
    int id;
    Employee(int id) 
        { 
    	this.id = id; 
    	}
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Only works if class is Cloneable
    }
}

public class p10 {
    public static void main(String[] args) throws Exception {
        Employee e1 = new Employee(101);
        Employee e2 = (Employee)e1.clone();
        System.out.println("Cloned ID: " + e2.id);
    }
}
