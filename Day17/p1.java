package Day17;
//1. Basic Try-Catch Example
public class p1 {
	public static void main(String[] args) {
      try {
          int result = 10 / 0; // This will throw ArithmeticException
          System.out.println(result);
      } 
      catch (ArithmeticException e) {
          System.out.println("Cannot divide by zero: " + e.getMessage());
      }
  }
}