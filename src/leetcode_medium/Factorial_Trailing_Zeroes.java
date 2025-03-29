package leetcode_medium;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * <p>
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * <p>
 * https://www.youtube.com/watch?v=zXapkyyWZBE&ab_channel=nETSETOS
 * <p>
 * Time Complexity: O(log5( n ) )
 * Space Complexity: O(1)
 */
public class Factorial_Trailing_Zeroes {
    //    The loop while (n > 0) continues to divide n by 5 and adds the quotient to count.
    //    For example, if n = 25:
    //    First iteration: n = 25 / 5 = 5, count = 5.
    //    Second iteration: n = 5 / 5 = 1, count = 5 + 1 = 6.
    //    Third iteration: n = 1 / 5 = 0, loop ends.
    //    The total count of trailing zeroes in 25! is 6.

    private static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Factorial Trailing Zeroes :  " + trailingZeroes(25));
        System.out.println("Factorial Trailing Zeroes :  " + trailingZeroes(5));
        System.out.println("Factorial Trailing Zeroes :  " + trailingZeroes(3));
    }
}
