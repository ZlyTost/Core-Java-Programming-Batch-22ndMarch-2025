package Day4;

import java.util.Scanner;

public class p11 {

	public static void main(String[] args) {
		// if else-if ladder
		//Grade evaluation
		
		float score;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n--------------------- Grade evaluation System ---------------------");
		
		System.out.println("Enter your Score please : ");
		score = sc.nextFloat();
		
		if(score>=90)
		{
			System.out.println("Grade : A ");
		}
		else if(score>=80)
		{
			System.out.println("Grade : B ");
		}
		else if(score>=60)
		{
			System.out.println("Grade : C ");
		}
		else if(score>=40)
		{
			System.out.println("Grade : D ");
		}
		else if(score<39)
		{
			System.out.println("Grade : Fail ");
		}
		else {
			System.out.println("Please enter valid Input");
		}
	}

}
