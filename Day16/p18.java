package Day16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 11. Validating Indian Vehicle Registration Number using Regular Expressions
public class p18 {

    public static void main(String[] args) {

        // Example Indian vehicle registration number in standard format
        String vehicleRegNumber = "MH 12 AB 1234";

        // Regular expression to match standard Indian vehicle registration format
        // Explanation:
        // ^               => Start of string
        // [A-Z]{2}        => Two uppercase letters (State code, e.g., MH, DL, UP)
        // ' '             => One space
        // \\d{2}          => Two digits (RTO code, e.g., 01, 12)
        // ' '             => One space
        // [A-Z]{2}        => Two uppercase letters (Series code, e.g., AB, CD)
        // ' '             => One space
        // \\d{4}          => Four digits (Vehicle number, e.g., 1234)
        // $               => End of string
        String regex = "^[A-Z]{2} \\d{2} [A-Z]{2} \\d{4}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create matcher to apply regex to the input registration number
        Matcher matcher = pattern.matcher(vehicleRegNumber);

        // Validate and print result
        if (matcher.matches()) {
            System.out.println("Valid Indian vehicle registration number.");
        } else {
            System.out.println("Invalid Indian vehicle registration number.");
        }
    }
}
