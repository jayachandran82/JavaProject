package leetcode_medium;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Time Complexity : O(n)
 * space Complexity: O(1)
 */
public class Basic_Calculator_II {
    private static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;

        int len = s.length();
        int result = 0;
        int currentNumber = 0;
        int lastNumber = 0;
        char operation = '+';

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == len - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = c;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Basic Calculation -  Scenario One : " + calculate("3+2*2"));
    }
}
