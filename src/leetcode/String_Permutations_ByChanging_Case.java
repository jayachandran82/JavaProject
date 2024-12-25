package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 * <p>
 * Example 1:
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * <p>
 * Time Complexity:  O(2n)
 * Space Complexity: O(n)
 */
public class String_Permutations_ByChanging_Case {
    //Backtracking
    public static void main(String[] args) {
        String_Permutations_ByChanging_Case obj = new String_Permutations_ByChanging_Case();
        String s = "a1b2";
        List<String> result = obj.findLetterPermutation(s);
        System.out.println(" Result : " + Arrays.toString(result.toArray()));
    }

    public List<String> findLetterPermutation(String str) {
        List<String> res = new ArrayList<>();
        findAllPermutation(res, str, 0);
        return res;
    }

    private void findAllPermutation(List<String> res, String str, int start) {
        res.add(str);
        for (int i = start; i < str.length(); i++) {
            char[] wordArray = str.toCharArray();
            if (Character.isLetter(str.charAt(i))) {
                if (Character.isUpperCase(wordArray[i])) {
                    wordArray[i] = Character.toLowerCase(str.charAt(i));
                    findAllPermutation(res, String.valueOf(wordArray), i + 1);
                } else {
                    wordArray[i] = Character.toUpperCase(str.charAt(i));
                    findAllPermutation(res, String.valueOf(wordArray), i + 1);
                }
            }
        }
    }
}
