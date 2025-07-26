package Day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 7. Validating a Password using Regular Expressions
public class p14 {

    public static void main(String[] args) {

        // Password to be validated
        String password = "Password123!";

        // Regular expression for a strong password
        // Explanation:
        // ^                         => Start of the string
        // (?=.*[a-z])               => At least one lowercase letter
        // (?=.*[A-Z])               => At least one uppercase letter
        // (?=.*\\d)                 => At least one digit
        // (?=.*[@$!%*?&])           => At least one special character from the list
        // [A-Za-z\\d@$!%*?&]{8,}    => Minimum 8 characters, only allowed characters
        // $                         => End of the string
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        // Compile the regular expression into a Pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object to compare the password against the pattern
        Matcher matcher = pattern.matcher(password);

        // Check if the password matches the required pattern
        if (matcher.matches()) {
            System.out.println("Valid password.");  // Strong and valid
        } else {
            System.out.println("Invalid password.");  // Doesn't meet one or more criteria
        }
    }
}
