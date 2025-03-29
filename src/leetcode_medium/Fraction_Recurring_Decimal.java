package leetcode_medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * If multiple answers are possible, return any of them.
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 * <p>
 * Example 1:
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Fraction_Recurring_Decimal {

    private static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle negative signs
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }

        //Handle number overflow
        long num = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        result.append(num / deno);

        num %= deno;
        if (num == 0) {
            return result.toString();
        }

        // Fractional part
        result.append(".");

        Map<Long, Integer> reminderMap = new HashMap<>();
        reminderMap.put(num, result.length());
        while (num != 0) {
            num *= 10;
            result.append(num / deno);
            num %= deno;
            if (reminderMap.containsKey(num)) {
                int index = reminderMap.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                reminderMap.put(num, result.length());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2)); // Output: "0.5"
        //System.out.println(fractionToDecimal(2, 1));    // Output: "2"
        System.out.println(fractionToDecimal(4, 333));  // Output: "0.(012)"
    }
}
