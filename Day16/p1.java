package Day16;

// Importing regex classes from the java.util.regex package
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 1. Validating an Email Address using Regular Expressions
public class p1 {

    public static void main(String[] args) {
        
        // Sample email address to validate
        String email = "example@example.com";
        
        // Regular expression (regex) pattern to validate standard email formats
        // Explanation:
        // ^                     => Start of string
        // [a-zA-Z0-9._%+-]+     => Matches one or more alphanumeric characters including ., _, %, +, -
        // @                     => Matches the "@" symbol
        // [a-zA-Z0-9.-]+        => Matches the domain name part (e.g., example, gmail)
        // \\.                   => Escaped dot "." to separate domain and TLD
        // [a-zA-Z]{2,}          => Matches TLD (top-level domain) like com, in, org (minimum 2 characters)
        // $                     => End of string
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Compile the regular expression into a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object to compare the email against the pattern
        Matcher matcher = pattern.matcher(email);

        // Use the matches() method to check if the email matches the regex pattern
        if (matcher.matches()) {
            // If it matches, it's a valid email
            System.out.println("Valid email address.");
        } else {
            // If it doesn't match, it's an invalid email
            System.out.println("Invalid email address.");
        }
    }
}
