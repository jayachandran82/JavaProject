package leetcode_easy;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * https://www.youtube.com/watch?v=y6ht-CoRI4Q&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Valid_Anagram {

    private static boolean isAnagram(String s, String t) {
        String str1 = s.toLowerCase();
        String str2 = t.toLowerCase();

        str1 = str1.replace(" ", "");
        str2 = str2.replace(" ", "");

        int[] counts = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            counts[str2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean isAnagram = isAnagram(s, t);
        System.out.println("It is Anagram:  " + isAnagram);
    }
}
