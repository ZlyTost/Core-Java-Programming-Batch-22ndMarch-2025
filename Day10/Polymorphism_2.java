package Day10;
//by changing types of parameters

class Calculator1 {
	//1 parameter
	void add(int a, int b)
	{
		System.out.println("Result : "+(a+b));
	}
	
	//2 parameter
	void add(int a,float b)
	{
		System.out.println("Result : "+(a+b));
	}
	
	//3 parameter
	void add(float a,float b)
	{
		System.out.println("Result : "+(a+b));
	}
}
public class Polymorphism_2 {
	public static void main(String[] args) {
		Calculator1 calc = new Calculator1();
		
		calc.add(5,7);
		calc.add(5, 6.5f);
		calc.add(1.4f, 2.7f);

	}

}
