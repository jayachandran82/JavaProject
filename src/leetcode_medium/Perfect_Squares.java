package leetcode_medium;

import java.util.Arrays;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * <p>
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * <p>
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * <p>
 * https://www.youtube.com/watch?v=q_E3wo8gRLU&ab_channel=HackerHeap
 * <p>
 * Time Complexity : O(n√n)  => O of n root n  ===> (O of n times the square root of n)
 * Space Complexity: O(n)
 */
public class Perfect_Squares {
    static private int perfectSqrt(int n) {
        int max = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=max; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                } else if (i > j * j) {
                    dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
                } else if (i < j * j) {
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;

        System.out.println("Result : " + perfectSqrt(n));
    }
}
