package leetcode_medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * https://www.youtube.com/watch?v=hK6Git1o42c&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class Word_Break {
    // Memorization Technic/ Dynamic Programing
    private static boolean wordBreak(String s, List<String> wordDict) {
        // Convert the dictionary to a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);

        // Find the maximum word length in the dictionary
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // Base case: empty string is valid
        dp[0] = true;

        // Check prefixes of length up to maxLen
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        boolean result = wordBreak(s, wordDict);
        System.out.println("Word Break: " + result);
    }
}
