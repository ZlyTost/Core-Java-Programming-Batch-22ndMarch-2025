package Day12;

/*Abstraction means hiding implementation details and showing only the essential 
features of an object.*/

//Employee Class
abstract class Emp{
	String name;
	int id;
	
	//constructor
	Emp(String name, int id){
		this.name= name;
		this.id = id;
	}
	
	//method
	void displayinfo() {
		System.out.println("Employee Name : "+name+
	                       "\nEmployee ID : "+id);
	}
	
	//abstract method
	abstract double calculateSalary();
}

//FullTimeEmployee
class FullTimeEmployee extends Emp{
	double MonthlySalary;

	FullTimeEmployee(String name, int id,double MonthlySalary) {
		super(name, id);
		this.MonthlySalary = MonthlySalary;
	}

	@Override
	double calculateSalary() {
		return MonthlySalary;
	}
}

//PartTimeEmployee
class PartTimeEmployee extends Emp{
	
	double hourlyRate;
	double hasWorked;

	PartTimeEmployee(String name, int id,double hourlyRate,double hasWorked) {
		super(name, id);
		this.hourlyRate = hourlyRate;
		this.hasWorked = hasWorked;
	}

	@Override
	double calculateSalary() {
		return hourlyRate*hasWorked;
	}	
}

public class Abstraction1 {

	public static void main(String[] args) {
		Emp e1 = new FullTimeEmployee("Kajal",103,90000.00);
		Emp e2 = new PartTimeEmployee("Tejas",104,200,100);
		
		e1.displayinfo();
		System.out.println("Salary : "+e1.calculateSalary());
		
		e2.displayinfo();
		System.out.println("Salary : "+e2.calculateSalary());
	}

}
