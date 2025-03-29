package leetcode_medium;

/**
 * You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
 * "1" -> 'A'
 * "2" -> 'B'
 * ...
 * "25" -> 'Y'
 * "26" -> 'Z'
 * However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").
 * For example, "11106" can be decoded into:
 * "AAJF" with the grouping (1, 1, 10, 6)
 * "KJF" with the grouping (11, 10, 6)
 * The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
 * Note: there may be strings that are impossible to decode.
 * Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation:
 * "12" could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * https://www.youtube.com/watch?v=FEkZxCl_-ik&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Decode_Ways {
    //Dynamic Programing
    // waysToDecode[i] = waysToDecode[i-1] (if new single digit is valid) + waysToDecode[i-2] (if last 2 digit is valid)

    static private int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(1) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Decode Ways : " + numDecodings("12"));
        System.out.println("Decode Ways : " + numDecodings("226"));
        System.out.println("Decode Ways : " + numDecodings("06"));
    }
}
