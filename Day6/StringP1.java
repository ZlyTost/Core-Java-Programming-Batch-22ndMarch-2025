package Day6;
//String patterns
public class StringP1 {
		//print a triangle
		public static void main(String[] args) {
			char dem = 'S';
			//String demo = "JAVA";
			for(int i=0;i<=6;i++)//outer loop represents rows
			{
				for(int j=0;j<=i;j++)//inner loop represents columns
				{
					System.out.print(dem +" ");
					//System.out.print(demo +" ");
				}
				System.out.println();//gives new line after 1 row
			}
		}
	}