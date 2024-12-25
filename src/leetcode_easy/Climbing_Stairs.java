package leetcode_easy;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * https://www.youtube.com/watch?v=UUaMrNOvSqg&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Climbing_Stairs {
    //Dynamic programming

    static private int climbingStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // -------------------------------------
        // | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
        // |   |   |   |   |   |   |   |   |   |
        // -------------------------------------
        int totalClimbing = climbingStairs(8);

        System.out.println("Total Climbing " + totalClimbing);
    }
}
