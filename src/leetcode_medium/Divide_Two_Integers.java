package leetcode_medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * Return the quotient after dividing dividend by divisor.
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 * <p>
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * <p>
 * https://www.youtube.com/watch?v=htX69j1jf5U&ab_channel=NideeshTerapalli
 * <p>
 * Time Complexity : O(log 2 n^2)
 * Space Complexity: O(1);
 */
public class Divide_Two_Integers {
    // Shifting Bit variable

    static private int divideTowInteger(int dividend, int divisor) {

        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MIN_VALUE;
        }
        int result = 0;
        int sign = 1;
        if (dividend >= 0 && divisor < 0 && dividend < 0 && divisor >= 0) {
            sign = -1;
        }

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while (a - b >= 0) {
            int count = 0;

            while (a - (b << 1 << count) >= 0) {
                count++;
            }

            result += 1 << count;
            a -= b << count;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        int result = divideTowInteger(dividend, divisor);
        System.out.println("Divide Two Integers : " + result);
    }
}
