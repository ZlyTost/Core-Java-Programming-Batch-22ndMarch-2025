package Day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 8. Validating Indian Mobile Numbers using Regular Expressions
public class p15 {

    public static void main(String[] args) {

        // Sample mobile number to be validated
        String mobileNumber = "9876543210";  // Should be 10 digits starting with 7, 8, or 9

        // Regular expression to validate Indian mobile number
        // Explanation:
        // ^            => Start of string
        // [789]        => First digit must be 7, 8, or 9
        // \\d{9}       => Followed by exactly 9 digits (total 10 digits)
        // $            => End of string
        String regex = "^[789]\\d{9}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create matcher to apply the pattern on the input number
        Matcher matcher = pattern.matcher(mobileNumber);

        // Validate and display result
        if (matcher.matches()) {
            System.out.println("Valid Indian mobile number.");
        } else {
            System.out.println("Invalid Indian mobile number.");
        }
    }
}
