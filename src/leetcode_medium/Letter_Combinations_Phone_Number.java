package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Time Complexity: O(k^n *n)
 * Space Complexity: O(k^n * n)
 */
public class Letter_Combinations_Phone_Number {
    //Depth First Search (DFS)
    //Back tracking

    static private List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();

        // Mapping of digits to corresponding letters on the phone keypad
        String[] strToChar = {
                "",     // 0 (no mapping)
                "",     // 1 (no mapping)
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };
        List<String> result = new ArrayList<>();
        dfs(digits, 0, new StringBuffer(), strToChar, result);
        return result;
    }

    static void dfs(String digits, int index, StringBuffer current, String[] strToChar, List<String> result) {
        // If the current combination is complete, add it to the result list
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the characters corresponding to the current digit
        String letters = strToChar[digits.charAt(index) - '0'];

        // Loop through each letter and recursively build the combination
        for (char c : letters.toCharArray()) {
            current.append(c); // Add the letter to the current combination
            dfs(digits, index + 1, current, strToChar, result); // Recur for the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack by removing the last letter
        }

    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> output = letterCombinations(digits);
        System.out.println("Letter Combinations of a Phone Number : " + output);

    }
}
