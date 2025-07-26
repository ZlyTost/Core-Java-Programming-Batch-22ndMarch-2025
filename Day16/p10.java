package Day16;

// Importing required classes for regular expression operations
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 2. Finding All Occurrences of a Word in a Given Text
public class p10 {

    public static void main(String[] args) {
        
        // Sample input text in which we want to search a specific word
        String text = "Java is a programming language. Java is also an island.";

        // The word to be searched for in the text (case-sensitive)
        String regex = "Java";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object to search the text using the compiled pattern
        Matcher matcher = pattern.matcher(text);

        // Use a loop to find all occurrences of the word "Java"
        while (matcher.find()) {
            // Print the starting index of each match found
            System.out.println("Found at index: " + matcher.start());
        }
    }
}
