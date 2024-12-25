package leetcode_easy;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three(³), if there exists an integer x such that n == (3)×
 * <p>
 * Example 1:
 * <p>
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 3³
 * <p>
 * Time Complexity : O(log³ n)
 * Space Complexity : O(1)
 */
public class Power_Three {
    private static boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 27;
        System.out.println(" isPower of Three : " + isPowerOfThree(n));
    }
}
