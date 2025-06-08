package Day9;

// 1. Single Inheritance
//One class inherits from one parent (superclass).

//parent/super/base class
class GrandFather {
	String name;
	int No_of_Plots;
	int Bank_Balance;
	
	GrandFather(String name,int No_of_Plots,int Bank_Balance){
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

//child/sub/derived class
class Father extends GrandFather{
	String Myname;
	int MY_No_of_Plots;
	int My_Bank_Balance;
	
	
	Father(String name,int No_of_Plots,int Bank_Balance){
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

public class Inheritance1 {
	public static void main(String[] args) {
		GrandFather G1 = new GrandFather("Mr. Ram Nihoda Mishra",5,5000000);
		G1.G_Property();
		
		Father F1 = new Father("Mr.Ramod Mishra", 11, 7200000);
		F1.G_Property();
		F1.M_Property();
		
		
		GrandFather G2 = new GrandFather("Mr. Kondiram Sawant",1,8000000);
		G2.G_Property();
		
		Father F2 = new Father("Mr.Vijay Sawant", 2, 78000000);
		F2.G_Property();
		F2.M_Property();
		
	}

}
