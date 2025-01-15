package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Time Complexity : O(n)
 * Space Complexity: O(1) ==> Characters are mapped directly to their ASCII values, allowing constant-time lookups and updates.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    //Sliding Window
    private static int lengthOfLongestSubstring(String s) {
        //The array size is constant (256 for ASCII values), so the space complexity is O(1).
        int[] lastSeen = new int[256];
        for (int i = 0; i < 256; i++) {
            lastSeen[i] = -1; // Initialize all positions to -1
        }
        int start = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If the character was seen before and is within the current window, move the start
            if (lastSeen[ch] >= start) {
                start = lastSeen[ch] + 1;
            }

            // Update the last seen index of the current character
            lastSeen[ch] = i;

            // Calculate the maximum length
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("abcabcbb");
        System.out.println("Longest Substring Without Repeating Characters  : " + result);
    }

}
