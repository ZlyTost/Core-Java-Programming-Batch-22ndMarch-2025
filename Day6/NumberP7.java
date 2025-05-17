package Day6;
//Number Patterns-7
public class NumberP7 {
		//print a triangle
		public static void main(String[] args) {
			for(int i=0;i<=6;i++)//outer loop represents rows
			{
				for(int j=0;j<=i;j++)//inner loop represents columns
				{
					System.out.print(i+" ");
				}
				System.out.println();//gives new line after 1 row
			}
		}
	}