package Day9;

//MultiLevel Inheritance
//A class inherits from a class which is already a child of another class.

//parent/super/base class for Father class
class GrandFather1 {
	String name;
	int No_of_Plots;
	int Bank_Balance;
	
	GrandFather1(String name,int No_of_Plots,int Bank_Balance){
		this.name=name;
		this.No_of_Plots=No_of_Plots;
		this.Bank_Balance=Bank_Balance;
	}
	
	void G_Property() {
		System.out.println("Name : "+ name
				+"No_of_Plots : "+ No_of_Plots
				+ "Bank_Balance :" + Bank_Balance);
	}
}

//child/sub/derived class for Grandfather
//parent/super/base class for Son class
class Father1 extends GrandFather1{
	String Myname;
	int MY_No_of_Plots;
	int My_Bank_Balance;
	
	
	Father1(String name,int No_of_Plots,int Bank_Balance){
		super(name, No_of_Plots, Bank_Balance); 
		// Calling the parent class constructor
		this.Myname=name;
		this.MY_No_of_Plots=No_of_Plots;
		this.My_Bank_Balance=Bank_Balance;
	}
	
	void M_Property() {
		System.out.println("Name : "+ Myname
				+"No_of_Plots : "+ MY_No_of_Plots
				+ "Bank_Balance :" + My_Bank_Balance);
	}
}
//child/sub/derived class for father
class Son extends Father1{
	String Sname;
	int S_No_of_Plots;
	int S_Bank_Balance;
	
	
	Son(String name,int No_of_Plots,int Bank_Balance){
		super(name, No_of_Plots, Bank_Balance); 
		// Calling the parent class constructor
		this.Sname=name;
		this.S_No_of_Plots=No_of_Plots;
		this.S_Bank_Balance=Bank_Balance;
	}
	
	void S_Property() {
		System.out.println("Name : "+ Sname
				+"No_of_Plots : "+ S_No_of_Plots
				+ "Bank_Balance :" + S_Bank_Balance);
	}
}
public class Inheritance2 {
	public static void main(String[] args) {
		GrandFather G1 = new GrandFather("Mr. Ram Nihoda Mishra",5,5000000);
		G1.G_Property();
		
		Father F1 = new Father("Mr.Ramod Mishra", 11, 7200000);
		F1.G_Property();
		F1.M_Property();
		
		Son S1 = new Son("Mr. Rahul Mishra", 12, 9200000);
		S1.G_Property();
		S1.M_Property();
		S1.S_Property();
		
		
		
		GrandFather G2 = new GrandFather("Mr. Kondiram Sawant",1,8000000);
		G2.G_Property();
		
		Father F2 = new Father("Mr.Vijay Sawant", 2, 78000000);
		F2.G_Property();
		F2.M_Property();
		
		Son S2 = new Son("Mr.Alankar Sawant", 2, 78000000);
		S2.G_Property();
		S2.M_Property();
		S2.S_Property();
	}

}
