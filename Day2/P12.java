package Day2;

import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		//Basic Input Output
		//1. Arithmetic Operator
		
				int num1, num2;//variable declaration
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter value of num1 : ");
				num1=sc.nextInt();
				
				System.out.println("Enter value of num2 : ");
				num2 = sc.nextInt();
				
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
