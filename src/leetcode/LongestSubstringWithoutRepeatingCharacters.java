package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given "abcabcbb", the answer is "abc", which the length is 3. Given "bbbbb",
 * the answer is "b", with the length of 1. Given "pwwkew", the answer is "wke",
 * with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j))
                    ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        int result = obj.lengthOfLongestSubstring("pwwkew");
        System.out.println("Result  : " + result);
    }

}
