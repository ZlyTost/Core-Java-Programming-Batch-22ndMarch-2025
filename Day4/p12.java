package Day4;

import java.util.Scanner;

public class p12 {

	public static void main(String[] args) {
		//Using Nested if-else
			int num;
			System.out.println("Enter a number : ");
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();
			
			if(num>=0)
			{
				System.out.println("Number is positive.");
				if(num%2==0)
				{
					System.out.println("Number is even");
				}
				else {
					System.out.println("Number is Odd");
				}
			}
			else
			{
				System.out.println("Number is negative.");
			}
		
	}

}
