package Day16;

// 3. Replacing All Digits in a String Using Regular Expressions
public class p11 {

    public static void main(String[] args) {

        // Sample input string containing digits (a phone number in this case)
        String input = "My phone number is 123-456-7890.";

        // Regular expression to match any single digit from 0 to 9
        // \d => Represents a digit (equivalent to [0-9])
        String regex = "\\d";  // Note: We use double backslash \\ to escape in Java strings

        // Replace all digits in the input string with an asterisk (*)
        String result = input.replaceAll(regex, "*");

        // Print the result after replacing all digits
        // Expected output: My phone number is ***-***-****.
        System.out.println(result);
    }
}
