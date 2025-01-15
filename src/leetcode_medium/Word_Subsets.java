package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two string arrays words1 and words2.
 * A string b is a subset of string a if every letter in b occurs in a including multiplicity.
 * For example, "wrr" is a subset of "warrior" but is not a subset of "world".
 * A string a from words1 is universal if for every string b in words2, b is a subset of a.
 * Return an array of all the universal strings in words1. You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * <p>
 * Time Complexity:  O( n*m + k * ℓ), where  𝑛 and 𝑚 are the lengths of words1 and words2, and 𝑘 and ℓ are the average lengths of strings in words1 and words2 respectively.
 * Space Complexity: O(1) for the frequency arrays.
 */
public class Word_Subsets {
    private static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = currentFrequency(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        for (String a : words1) {
            int[] freq = currentFrequency(a);
            if (isUniversal(freq, maxFreq)) {
                result.add(a);
            }
        }
        return result;

    }

    private static boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] currentFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    public static void main(String[] args) {

        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        System.out.println("Result: " + wordSubsets(words1, words2));
    }
}
