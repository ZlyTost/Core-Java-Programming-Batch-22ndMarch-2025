package Day10;
/*
What is Polymorphism in Java?

Polymorphism means "many forms."
It allows an object to behave in multiple ways using one name.

there are two types of Polymorphism:

1. Compile-Time Polymorphism (Method Overloading)
   -- by changing no of parameters
   -- by changing types of parameters
   
2. Run-Time Polymorphism (Method Overriding)
   -- by using inheritance
 */


//by changing no of parameters

class Calculator {
	//1 parameter
	void add(int a)
	{
		System.out.println("Result : "+(a+2));
	}
	
	//2 parameter
	void add(int a,int b)
	{
		System.out.println("Result : "+(a+b));
	}
	
	//3 parameter
	void add(int a,int b,int c)
	{
		System.out.println("Result : "+(a+b+c));
	}
}
public class Polymorphism_1 {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.add(5);
		calc.add(5, 6);
		calc.add(1, 2, 3);

	}

}
