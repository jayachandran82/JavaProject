package leetcode_medium;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * The algorithm for myAtoi(string s) is as follows:
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * Example 1:
 * Input: s = "42"
 * Output: 42
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class String_To_Integer {
    static private int myAtoi(String s) {
        if (s == null && s.isEmpty()) {
            return 0;
        }
        int i = 0, result = 0, sign = 1, n = s.length();

        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // Handle sign
        if (i < n && s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            // Check for overflow
            if (result > Integer.MAX_VALUE || result == Integer.MAX_VALUE && s.charAt(i) - '0' > 7) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }

        //Return the result with the correct sign
        return sign * result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Scenario One : " + myAtoi("42")); // Output: 42
        System.out.println("Scenario Two : " + myAtoi("   -42")); // Output: -42
        System.out.println("Scenario Three : " + myAtoi("4193 with words")); // Output: 4193
        System.out.println("Scenario Four : " + myAtoi("words and 987")); // Output: 0
        System.out.println("Scenario Five : " + myAtoi("-91283472332")); // Output: -2147483648

    }
}
