package Day17;
// Basic Try-Catch Example
public class demo {

	public static void main(String[] args) {
		try {
			System.out.println("Statement-1");
			System.out.println("Statement-2");
			System.out.println("Statement-3");
			System.out.println("Statement-4");
			System.out.println("Statement-5");
			int result = 10 / 0; // This will throw ArithmeticException
	          System.out.println(result);
		}
	      catch (Exception e) {
	          System.out.println(e);
	      }
		System.out.println("Statement-6");
		System.out.println("Statement-7");
		System.out.println("Statement-8");
		System.out.println("Statement-9");
		System.out.println("Statement-10");
	}

}
