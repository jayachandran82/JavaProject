package leetcode_easy;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class Reverse_String {

    private static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] ch = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Actual Characters : " + Arrays.toString(ch));
        reverseString(ch);
        System.out.println("Reverse Characters : " + Arrays.toString(ch));
    }
}
