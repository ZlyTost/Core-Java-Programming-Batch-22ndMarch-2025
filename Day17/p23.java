package Day17;
//9. Logging Exceptions
import java.util.logging.*;
public class p23 {

	    private static final Logger logger = Logger.getLogger(p23.class.getName());

	    public static void main(String[] args) {
	        try {
	            int result = 10 / 0; // This will throw ArithmeticException
	        } catch (ArithmeticException e) {
	            logger.log(Level.SEVERE, "Exception occurred: ", e);
	        }
	    }
	}