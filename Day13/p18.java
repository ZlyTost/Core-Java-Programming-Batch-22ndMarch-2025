package Day13;
/*
 4. Private Constructor
Used for Singleton pattern or to prevent object creation.
 */

//Example 1: Singleton Logger
class Logger {
    private static Logger obj = new Logger();  // single object

    private Logger() {}  // private constructor

    public static Logger getInstance() {
        return obj;
    }
}

public class p18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
