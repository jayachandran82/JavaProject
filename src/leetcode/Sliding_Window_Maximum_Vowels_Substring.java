package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * <p>
 * https://www.youtube.com/watch?v=FEXJGn19u7Y&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexit: O(1)
 */
public class Sliding_Window_Maximum_Vowels_Substring {
    public static void main(String[] args) {
        String str = "abciiidef";
        int k = 3;
        int result = maxVowelCount(str, k);
        System.out.println("Result " + result);
    }

    static int maxVowelCount(String str, int k) {
        int maxVowel = 0;
        int windowsVowel = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < k; i++) {
            if (vowels.contains(str.charAt(i))) {
                windowsVowel++;
            }
        }
        maxVowel = windowsVowel;

        for (int i = k; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i - k))) {
                windowsVowel--;
            }
            if (vowels.contains(str.charAt(i))) {
                windowsVowel++;
            }
            maxVowel = Math.max(windowsVowel, maxVowel);
        }
        return maxVowel;
    }
}
