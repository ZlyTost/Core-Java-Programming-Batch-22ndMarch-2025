package Day11;
//This Keyword
//distinguishing instance variable from parameter variable
public class d1 {
	String Name;
	int age;
	//constructor
	d1(String Name,int age)
	{
		this.Name=Name; //this.Name represents instance variable of demo1 class
		this.age=age;
	}
	//methods
	void display()
	{
		System.out.println("Name : "+Name
				+"\nAge : "+age);
	}
	public static void main(String[] args) {
	
		d1 obj = new d1("Tejas",22);
		
		obj.display();

	}

}
