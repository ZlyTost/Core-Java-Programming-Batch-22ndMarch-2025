package Day11;
//b) Final method
class P {
    final void show() {
        System.out.println("Final method of parent");
    }
}

class C extends P {
    // void show() {} // Error: Cannot override final method
}

public class p16 {

	public static void main(String[] args) {
		C c = new C();
		c.show();
	}

}
