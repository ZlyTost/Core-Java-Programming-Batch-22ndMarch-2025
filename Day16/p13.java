package Day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 6. Extracting Digits from a String using Regular Expressions
public class p13 {

    public static void main(String[] args) {

        // Input string that contains numbers along with text
        String input = "Order number: 12345, Quantity: 10.";

        // Regular expression to match one or more digits
        // \\d  => Matches any single digit [0-9]
        // +    => One or more occurrences
        String regex = "\\d+";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object that will search the input string
        Matcher matcher = pattern.matcher(input);

        // Loop through all matches found
        while (matcher.find()) {
            // matcher.group() returns the matched digits
            System.out.println("Found digit: " + matcher.group());
        }
    }
}
