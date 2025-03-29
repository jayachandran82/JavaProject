package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A substring is a contiguous non-empty sequence of characters within a string.
 * A palindrome is a string that reads the same forward and backward.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * <p>
 * https://www.youtube.com/watch?v=H2qx2Kr81Bo&ab_channel=CodingDecoded
 * <p>
 * Time Complexity: O(N * 2^N)
 * Space Complexity : O(2^N * N)
 */
public class Palindrome_Partitioning {
    //backtracking

    private static List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();
        backTracking(result, new ArrayList<>(), 0, str);
        return result;
    }

    static void backTracking(List<List<String>> result, List<String> currentList, int start, String str) {
        if (start == str.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                currentList.add(str.substring(start, i + 1));
                backTracking(result, currentList, i + 1, str);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> result = partition(str);
        System.out.println("Palindrome Partitioning :  " + result);
    }
}
