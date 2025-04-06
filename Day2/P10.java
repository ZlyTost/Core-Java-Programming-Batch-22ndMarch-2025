package Day2;
/*An operator in Java is a special symbol or keyword used to perform operations 
on variables and values.*/

public class P10 {

	public static void main(String[] args) {
		//1. Arithmetic Operator
		
		int num1, num2;//variable declaration
		num1=5;
		num2=6;
		
		//Addition
		int result1 = num1+num2;
		
		System.out.println("Addition of 2 numbers : "+ result1);
		
		//Subtraction
		int result2 = num1-num2;
		System.out.println("Subtraction of 2 numbers : "+ result2);
		
		//Mutiplication
		int result3 = num1*num2;
		System.out.println("Multiplication of 2 numbers : "+ result3);
		
		//Division
		float result4 = num1/num2;
		System.out.println("Devision of 2 numbers : "+ result4);
		
		//Modulus
		float result5 = num1%num2;
		System.out.println("Modulus of 2 numbers : "+ result5);
	}

}
