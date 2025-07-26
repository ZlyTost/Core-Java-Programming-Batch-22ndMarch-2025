package Day16;

// 4. Splitting a String Using Regular Expressions
public class p12 {

    public static void main(String[] args) {

        // Sample text containing punctuation and spaces
        String text = "Hello, world! Welcome to Java programming.";

        // Regular expression to split the text
        // [\\s,!.]+ explanation:
        //   \\s  -> Matches any whitespace character (spaces, tabs, newlines)
        //   ,    -> Matches a comma
        //   !    -> Matches an exclamation mark
        //   .    -> Matches any character, BUT here we escape it with \\.
        //   +    -> Matches one or more occurrences of the above characters
        String regex = "[\\s,!.]+";

        // Splits the text based on the defined regex pattern
        // This will remove punctuation and split based on space/comma/exclamation/dot
        String[] words = text.split(regex);

        // Loop to print each word separately
        for (String word : words) {
            System.out.println(word);
        }
    }
}
