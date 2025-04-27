package Day4;

import java.util.Scanner;

public class p10 {

	public static void main(String[] args) {
		// if else statement
		
		int age;
		boolean IsCitizen;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n------------------- Voting System ---------------------\n");
		
		System.out.println("Enter your Age :");
		age =sc.nextInt();
		
		System.out.println("Are you Citizen of India : true/false");
		IsCitizen = sc.hasNext();
		
		if(age>=18 && IsCitizen)
		{
			System.out.println("you are eligible for voting..");
		}
		else
		{
			System.out.println("you are not eligible for voting..");
		}
	}

}
