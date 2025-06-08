package Day9;
//static methods
public class p3 {

	public static int add(int a , int b)
	{
		return a+b;
	}
	public static void main(String[] args) {
		int sum=add(2,3);
		int sum1 = p3.add(2, 9);
		
		System.out.println(sum);
		System.out.println(sum1);
	}

}
