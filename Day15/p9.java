package Day15;

import java.util.StringJoiner;

public class p9 {
//Program 25: String Joining
	public static void main(String[] args) {
		StringJoiner joiner = new StringJoiner(", ");
        joiner.add("Pizza");
        joiner.add("Burger");
        joiner.add("Pasta");
        System.out.println("Menu: " + joiner.toString());
	}

}
