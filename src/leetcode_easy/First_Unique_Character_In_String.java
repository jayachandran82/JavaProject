package leetcode_easy;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation:
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class First_Unique_Character_In_String {
    private static int firstUniqueChar(String str) {
        int index = -1;
        int[] charCount = new int[26];

        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (charCount[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        int result = firstUniqueChar(str);
        System.out.println("First Unique Character Index - Scenario-One:  " + result);

        int scenario2 = firstUniqueChar("loveleetcode");
        System.out.println("First Unique Character Index - Scenario-Two :  " + scenario2);
    }
}
