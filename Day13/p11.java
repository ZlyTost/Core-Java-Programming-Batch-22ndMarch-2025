package Day13;
//Example 3: Custom Marker Interface
interface PremiumUser {}  // Marker only

class User implements PremiumUser {
    String name = "Shalini";
}

public class p11 {
    public static void main(String[] args) {
        User u = new User();
        if (u instanceof PremiumUser) {
            System.out.println("Show Premium Features to: " + u.name);
        }
    }
}
