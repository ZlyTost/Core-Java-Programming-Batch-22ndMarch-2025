package Day17;
//10. Final vs Finally vs Finalize
public class p24 {
	    @Override
	    protected void finalize() throws Throwable {
	        System.out.println("Finalize method called");
	    }

	    public static void main(String[] args) {
	        p24 obj = new p24();
	        obj = null; // Make the object eligible for garbage collection
	        System.gc(); // Request garbage collection
	        System.out.println("Garbage collection requested");
	    }
	}