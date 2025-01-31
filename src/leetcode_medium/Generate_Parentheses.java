package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * Time Complexity: O(2* n)
 * Space Complexity: The space complexity is O(n) due to the recursion stack and the space used to store the result.
 */
public class Generate_Parentheses {
    //Back tracking
    //Depth First Search (DFS)

    static private List<String> generateParenthesis(int n) {
        List<String> output_str = new ArrayList<>();
        backtracking("", output_str, 0, 0, n);
        return output_str;
    }

    static void backtracking(String currentStr, List<String> output_str, int open, int close, int max) {
        if (currentStr.length() == max * 2) {
            output_str.add(currentStr);
            return;
        }
        if (open < max) {
            backtracking(currentStr + "(", output_str, open + 1, close, max);
        }
        if (close < open) {
            backtracking(currentStr + ")", output_str, open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        List<String> output_result = generateParenthesis(3);
        System.out.println("Generate Parentheses : " + output_result);
    }
}
