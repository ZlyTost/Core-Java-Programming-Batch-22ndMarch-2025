package Day6;
//Number Pattern-4
public class NumberP4 {
     //print a triangle
				public static void main(String[] args) {
					int count=9;
					for(int i=1;i<5;i++)//outer loop represents rows
					{
						for(int j=1;j<=i;j++)//inner loop represents columns
						{
							System.out.print(count+" ");
							count--;
						}
						System.out.println();//gives new line after 1 row
					}
				}
			}