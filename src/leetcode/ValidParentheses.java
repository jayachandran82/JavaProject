package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{()}";
        boolean status = isValid(s);
        System.out.println("isValid : " + status);

    }

    // O(N) time Complexity
    // O(N) Space complexity
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
