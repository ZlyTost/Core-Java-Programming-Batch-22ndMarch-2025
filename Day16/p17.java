package Day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 10. Validating Indian Aadhaar Number using Regular Expressions
public class p17 {

    public static void main(String[] args) {

        // Sample Aadhaar number (12 digits with space separators)
        String aadharNumber = "1234 5678 9012";

        // Regular expression to validate the Aadhaar number format
        // Explanation:
        // ^                 => Start of string
        // [2-9]{1}          => First digit must be from 2 to 9 (Aadhaar can't start with 0 or 1)
        // [0-9]{3}          => Next 3 digits (making first group 4 digits)
        // ' ' (space)       => A space
        // [0-9]{4}          => Next group of 4 digits
        // ' ' (space)       => Another space
        // [0-9]{4}          => Last group of 4 digits
        // $                 => End of string
        String regex = "^[2-9]{1}[0-9]{3} [0-9]{4} [0-9]{4}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create matcher to apply pattern on the given Aadhaar number
        Matcher matcher = pattern.matcher(aadharNumber);

        // Check and print whether the Aadhaar number is valid
        if (matcher.matches()) {
            System.out.println("Valid Indian Aadhar number.");
        } else {
            System.out.println("Invalid Indian Aadhar number.");
        }
    }
}
