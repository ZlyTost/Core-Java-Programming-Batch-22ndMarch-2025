package Day9;

//Hirarical Inheritance
//Multiple classes inherit from a single parent class.

//parent/super/base class for Father class
class GrandFather2 {
	String name;
	int No_of_Plots;
	int Bank_Balance;
	
	GrandFather2(String name,int No_of_Plots,int Bank_Balance){
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
class Father2 extends GrandFather2{
	String Myname;
	int MY_No_of_Plots;
	int My_Bank_Balance;
	
	
	Father2(String name,int No_of_Plots,int Bank_Balance){
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
//child/sub/derived class for GrandFather
class Son2 extends GrandFather2{
	String Sname;
	int S_No_of_Plots;
	int S_Bank_Balance;
	
	
	Son2(String name,int No_of_Plots,int Bank_Balance){
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

//child/sub/derived class for GrandFather
class Daughter2 extends GrandFather2{
	String Sname;
	int S_No_of_Plots;
	int S_Bank_Balance;
	
	
	Daughter2(String name,int No_of_Plots,int Bank_Balance){
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
public class Inheritance3 {
	public static void main(String[] args) {
		GrandFather2 G1 = new GrandFather2("Mr. Ram Nihoda Mishra",5,5000000);
		G1.G_Property();

		Father2 F1 = new Father2("Mr.Ramod Mishra", 11, 7200000);
		F1.G_Property();
		F1.M_Property();
		
		
		Son2 S1 = new Son2("Mr. Rahul Mishra", 12, 9200000);
		S1.G_Property();
		S1.S_Property();

		Daughter2 D1 = new Daughter2("Kajal Mishra", 1, 9200000);
		D1.G_Property();
		D1.S_Property();
		
		GrandFather2 G2 = new GrandFather2("Mr. Kondiram Sawant",1,8000000);
		G2.G_Property();
		
		Father2 F2 = new Father2("Mr.Vijay Sawant", 2, 78000000);
		F2.G_Property();
		F2.M_Property();
		
		Son2 S2 = new Son2("Mr.Alankar Sawant", 2, 78000000);
		S2.G_Property();
		S2.S_Property();
		
		Daughter2 D2 = new Daughter2("Anamika Sawant", 1, 9200000);
		D2.G_Property();
		D2.S_Property();

	}

}
