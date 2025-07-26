package Day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 9. Validating Indian Postal Codes (PIN Codes) using Regular Expressions
public class p16 {

    public static void main(String[] args) {

        // Example Indian PIN code to validate
        String pinCode = "110001";  // Indian postal codes have exactly 6 digits

        // Regular expression for validating Indian PIN code
        // Explanation:
        // ^             => Start of the string
        // [1-9]         => First digit must be from 1 to 9 (cannot start with 0)
        // [0-9]{5}      => Followed by exactly 5 digits (0 to 9)
        // $             => End of the string
        // Together => Exactly 6 digits, first digit not 0
        String regex = "^[1-9][0-9]{5}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to apply the pattern on the PIN code
        Matcher matcher = pattern.matcher(pinCode);

        // Validate and print result
        if (matcher.matches()) {
            System.out.println("Valid Indian PIN code.");
        } else {
            System.out.println("Invalid Indian PIN code.");
        }
    }
}
