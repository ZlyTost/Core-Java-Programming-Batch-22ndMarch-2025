package Day9;
//This Keyword
//distinguishing instance variable from parameter variable
public class p1 {
	String Name;
	int age;
	//constructor
	p1(String Name,int age)
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
	
		p1 obj = new p1("Tejas",22);
		
		obj.display();

	}

}
