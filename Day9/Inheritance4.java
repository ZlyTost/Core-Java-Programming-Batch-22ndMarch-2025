package Day9;


//4. Multiple Inheritance (Not supported with classes)
//Java does not support multiple inheritance with classes to avoid diamond 
//problem. But you can achieve multiple inheritance with interfaces.

// 5. Hybrid Inheritance (Combination of two or more types)
//Java does not support hybrid inheritance with classes directly.
//But it can be achieved using interfaces.

//parent/super/base class for Father class
class GrandFather3 {
	String name;
	int No_of_Plots;
	int Bank_Balance;
	
	GrandFather3(String name,int No_of_Plots,int Bank_Balance){
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

//single Inheritance
class Father3 extends GrandFather3{
	String Myname;
	int MY_No_of_Plots;
	int My_Bank_Balance;
	
	
	Father3(String name,int No_of_Plots,int Bank_Balance){
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

//multilevel
class Son3 extends Father3{
	String Sname;
	int S_No_of_Plots;
	int S_Bank_Balance;
	
	
	Son3(String name,int No_of_Plots,int Bank_Balance){
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

//Hirarical
class Daughter3 extends Father3{
	String Sname;
	int S_No_of_Plots;
	int S_Bank_Balance;
	
	
	Daughter3(String name,int No_of_Plots,int Bank_Balance){
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
public class Inheritance4 {
	public static void main(String[] args) {
		GrandFather3 G1 = new GrandFather3("Mr. Ram Nihoda Mishra",5,5000000);
		G1.G_Property();

		Father3 F1 = new Father3("Mr.Ramod Mishra", 11, 7200000);
		F1.G_Property();
		F1.M_Property();
		
		Son3 S1 = new Son3("Mr. Rahul Mishra", 12, 9200000);
		S1.G_Property();
		S1.M_Property();
		S1.S_Property();
		
		Daughter3 D1 = new Daughter3("Kajal Mishra", 1, 9200000);
		D1.G_Property();
		D1.M_Property();
		D1.S_Property();
		
		GrandFather3 G2 = new GrandFather3("Mr. Kondiram Sawant",1,8000000);
		G1.G_Property();
		
		Father3 F2 = new Father3("Mr.Vijay Sawant", 2, 78000000);
		F1.G_Property();
		F1.M_Property();
		
		Son3 S2 = new Son3("Mr.Alankar Sawant", 2, 78000000);
		S1.G_Property();
		S1.M_Property();
		S1.S_Property();
		
		Daughter3 D2 = new Daughter3("Anamika Sawant", 1, 9200000);
		D1.G_Property();
		D1.M_Property();
		D1.S_Property();
 	}

}
