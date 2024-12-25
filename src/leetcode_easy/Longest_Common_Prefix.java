package leetcode_easy;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class Longest_Common_Prefix {

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        String common_Prefix = longestCommonPrefix(str);
        System.out.println("Common Prefix : " + common_Prefix);

    }

    static String longestCommonPrefix(String[] str) {
        Arrays.sort(str);

        String start = str[0];
        String end = str[str.length - 1];
        int minLength = Math.min(start.length(), end.length());
        int i = 0;
        while (i < minLength && start.charAt(i) == end.charAt(i)) {
            i++;
        }
        return start.substring(0, i);
    }
}
